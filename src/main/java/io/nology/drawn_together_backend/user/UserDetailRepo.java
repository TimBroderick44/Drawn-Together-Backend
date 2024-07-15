package io.nology.drawn_together_backend.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailRepo extends JpaRepository<UserDetail, Long> {
  Optional<UserDetail> findByEmail(String email);
}
