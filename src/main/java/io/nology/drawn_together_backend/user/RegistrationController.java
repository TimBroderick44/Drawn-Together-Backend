package io.nology.drawn_together_backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.nology.drawn_together_backend.errorhandling.RegistrationException;

@RestController
@RequestMapping("/auth")
public class RegistrationController {

  @Autowired
  private RegistrationService registrationService;

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@RequestBody RegistrationRequestDTO registrationRequest) {
    try {
      String result = registrationService.registerUser(registrationRequest);
      return ResponseEntity.ok(result);
    } catch (RegistrationException e) {
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }
}
