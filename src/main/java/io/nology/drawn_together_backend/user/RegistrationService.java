package io.nology.drawn_together_backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

  @Autowired
  private UserAuthRepo userAuthRepo;

  @Autowired
  private UserDetailRepo userDetailRepo;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  public String registerUser(RegistrationRequestDTO registrationRequest) {
    if (userAuthRepo.findByUsername(registrationRequest.getUsername()).isPresent()) {
      return "Username already taken";
    }

    if (userDetailRepo.findByEmail(registrationRequest.getEmail()).isPresent()) {
      return "Email already registered";
    }

    UserAuth userAuth = new UserAuth();
    userAuth.setUsername(registrationRequest.getUsername());
    userAuth.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
    userAuth = userAuthRepo.save(userAuth);

    UserDetail userDetail = new UserDetail();
    userDetail.setUserId(userAuth.getId());
    userDetail.setName(registrationRequest.getName());
    userDetail.setEmail(registrationRequest.getEmail());
    userDetailRepo.save(userDetail);

    return "User registered successfully";
  }
}
