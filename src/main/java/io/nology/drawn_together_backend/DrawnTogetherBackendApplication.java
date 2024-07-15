package io.nology.drawn_together_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"io.nology.drawn_together_backend"})
public class DrawnTogetherBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrawnTogetherBackendApplication.class, args);
	}

}
