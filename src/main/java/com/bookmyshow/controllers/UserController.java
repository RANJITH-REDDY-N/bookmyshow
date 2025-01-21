package com.bookmyshow.controllers;

import com.bookmyshow.dtos.LoginRequestDTO;
import com.bookmyshow.dtos.SignupRequestDTO;
import com.bookmyshow.dtos.UserResponseDTO;
import com.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public UserResponseDTO signup(@RequestBody SignupRequestDTO request) {
        return userService.signup(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO request) {
        return userService.login(request);
    }
}
