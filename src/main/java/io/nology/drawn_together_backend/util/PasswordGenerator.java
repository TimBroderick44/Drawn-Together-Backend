package io.nology.drawn_together_backend.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println("admin: " + encoder.encode("admin"));
        System.out.println("userpassword: " + encoder.encode("userpassword"));
        System.out.println("password: " + encoder.encode("password"));
        System.out.println("DrawnTogether2024: " + encoder.encode("DrawnTogether2024"));
        System.out.println("Sppoky89: " + encoder.encode("Spooky89"));
        System.out.println("BeepBopBoop: " + encoder.encode("BeepBopBoop"));
        System.out.println("FlyToTheMoon: " + encoder.encode("FlyToTheMoon"));
        System.out.println("GoldenBoy: " + encoder.encode("GoldenBoy"));
    }
}
