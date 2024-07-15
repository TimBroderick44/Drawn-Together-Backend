package io.nology.drawn_together_backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class RegistrationController {

  @Autowired
  private RegistrationService registrationService;

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@RequestBody RegistrationRequestDTO registrationRequest) {
    String result = registrationService.registerUser(registrationRequest);
    if (result.equals("User registered successfully")) {
      return ResponseEntity.ok(result);
    } else {
      return ResponseEntity.status(400).body(result);
    }
  }
}
