package io.nology.drawn_together_backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

  @Autowired
  private UserAuthRepo userAuthRepo;

  @Autowired
  private UserDetailRepo userDetailRepo;

  @GetMapping("/check-username")
  public ResponseEntity<Boolean> checkUsername(@RequestParam String username) {
    boolean exists = userAuthRepo.findByUsername(username).isPresent();
    return ResponseEntity.ok(exists);
  }

  @GetMapping("/check-email")
  public ResponseEntity<Boolean> checkEmail(@RequestParam String email) {
    boolean exists = userDetailRepo.findByEmail(email).isPresent();
    return ResponseEntity.ok(exists);
  }
}
