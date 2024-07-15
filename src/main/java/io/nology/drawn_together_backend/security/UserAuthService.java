package io.nology.drawn_together_backend.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.nology.drawn_together_backend.user.UserAuth;
import io.nology.drawn_together_backend.user.UserAuthRepo;

@Service
public class UserAuthService implements UserDetailsService {

  @Autowired
  private UserAuthRepo userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserAuth user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
        new ArrayList<>());
  }
}
