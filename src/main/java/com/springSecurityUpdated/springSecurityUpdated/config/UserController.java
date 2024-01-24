package com.springSecurityUpdated.springSecurityUpdated.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springSecurityUpdated.springSecurityUpdated.controller.UserService;


@RestController
@RequestMapping("/signup")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/checkUsername")
    public ResponseEntity<?> checkUsernameAvailability(@RequestParam String username) {
        // Check if the username exists in the database
        boolean isUsernameTaken = userService.isUsernameTaken(username);

        if (isUsernameTaken) {
            return ResponseEntity.ok(new ApiResponse("Username is already taken"));
        } else {
            return ResponseEntity.ok(new ApiResponse("Username is available"));
        }
    }

    @PostMapping("/checkEmail")
    public ResponseEntity<?> checkEmailAvailability(@RequestParam String email) {
        // Check if the email exists in the database
        boolean isEmailTaken = userService.isEmailTaken(email);

        if (isEmailTaken) {
            return ResponseEntity.ok(new ApiResponse("Email is already registered"));
        } else {
            return ResponseEntity.ok(new ApiResponse("Email is available"));
        }
    }
}

