package io.nology.drawn_together_backend.user;

import jakarta.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetail {
  @Id
  private Long userId;

  @Column(nullable = false)
  private String name;

  @Column(unique = true, nullable = false)
  private String email;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
