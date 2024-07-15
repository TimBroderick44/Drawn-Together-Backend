package io.nology.drawn_together_backend.security;

public class AuthResponseDTO {
  private final String jwt;
  private final String name;
  private final String email;

  public AuthResponseDTO(String jwt, String name, String email) {
    this.jwt = jwt;
    this.name = name;
    this.email = email;
  }

  public String getJwt() {
    return jwt;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}
