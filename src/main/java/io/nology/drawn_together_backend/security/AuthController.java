package io.nology.drawn_together_backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import io.nology.drawn_together_backend.user.UserAuth;
import io.nology.drawn_together_backend.user.UserAuthRepo;
import io.nology.drawn_together_backend.user.UserDetail;
import io.nology.drawn_together_backend.user.UserDetailRepo;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserAuthRepo userAuthRepo;

    @Autowired
    private UserDetailRepo userDetailRepo;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequestDTO authRequest) throws Exception {
        try {
            // .authenticate() method will authenticate the user and throw an exception if
            // the user is not authenticated
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Incorrect username or password");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while processing the request");
        }

        // userAuth is the username and password
        // userDetail is the user's name and email
        // The response will be returned with the JWT (and therefore the username), name and email so that they can be used in the frontend

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        // Generate the JWT token with the user details
        final String jwt = jwtUtil.generateToken(userDetails);

        Optional<UserAuth> userAuth = userAuthRepo.findByUsername(userDetails.getUsername());

        if (userAuth.isPresent()) {
            Optional<UserDetail> userDetail = userDetailRepo.findById(userAuth.get().getId());
            if (userDetail.isPresent()) {
                AuthResponseDTO response = new AuthResponseDTO(jwt, userDetail.get().getName(),
                        userDetail.get().getEmail());
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(500).body("User not found");
            }
        } else {
            return ResponseEntity.status(500).body("User not found");
        }
    }
}
