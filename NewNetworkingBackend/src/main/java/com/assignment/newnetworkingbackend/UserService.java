package com.assignment.newnetworkingbackend;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor Injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(User user) {
        // Check if username or email already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            return "Error: Username is already taken!";
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Error: Email is already in use!";
        }

        // NOTE: In production, always encode the password before saving! (e.g., BCrypt)
        userRepository.save(user);
        return "User registered successfully!";
    }

    public String loginUser(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isEmpty()) {
            return "Error: User not found!";
        }

        User user = userOpt.get();

        // Simple plain-text password match for this example
        if (!user.getPassword().equals(password)) {
            return "Error: Invalid password!";
        }

        return "Login successful! Welcome " + user.getUsername();
    }
}
