package com.bookmyshow.services;

import com.bookmyshow.dtos.SignupRequestDTO;
import com.bookmyshow.dtos.LoginRequestDTO;
import com.bookmyshow.dtos.UserResponseDTO;
import com.bookmyshow.models.User;
import com.bookmyshow.repositories.UserRepository;
import com.bookmyshow.utils.JwtUtils;
import com.bookmyshow.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordUtils passwordUtils;

    @Autowired
    private JwtUtils jwtUtils;

    public UserResponseDTO signup(SignupRequestDTO request) {
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Email already registered!");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordUtils.hashPassword(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().toString());
        return response;
    }

    public String login(LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if (!passwordUtils.validatePassword(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return jwtUtils.generateToken(user);
    }
}
