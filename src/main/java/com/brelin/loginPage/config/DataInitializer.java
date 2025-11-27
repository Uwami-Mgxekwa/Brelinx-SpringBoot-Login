package com.brelin.loginPage.config;

import com.brelin.loginPage.model.User;
import com.brelin.loginPage.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {
    
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Create a test user: username = "admin", password = "password"
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("password"));
            admin.setEmail("admin@brelinx.com");
            admin.setRole("ADMIN");
            
            userRepository.save(admin);
            
            System.out.println("✅ Test user created!");
            System.out.println("   Username: admin");
            System.out.println("   Password: password");
        };
    }
}
