package io.nology.drawn_together_backend.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepo extends JpaRepository<UserAuth, Long> {
  Optional<UserAuth> findByUsername(String username);
}
