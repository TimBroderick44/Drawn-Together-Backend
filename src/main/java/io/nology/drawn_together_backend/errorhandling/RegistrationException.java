package io.nology.drawn_together_backend.errorhandling;

public class RegistrationException extends RuntimeException {
  public RegistrationException(String message) {
    super(message);
  }
}
