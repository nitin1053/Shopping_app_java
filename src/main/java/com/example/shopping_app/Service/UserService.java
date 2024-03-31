package com.example.shopping_app.Service;

import com.example.shopping_app.Model.User;
import com.example.shopping_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            // Handle case where user is not found
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }
}
