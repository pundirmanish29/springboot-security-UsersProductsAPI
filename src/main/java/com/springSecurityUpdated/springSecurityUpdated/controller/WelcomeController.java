package com.springSecurityUpdated.springSecurityUpdated.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springSecurityUpdated.springSecurityUpdated.model.User;

@Controller
@RequestMapping
public class WelcomeController {

    @Autowired
    private UserService userService;


@GetMapping("/")
    public String goHome() {
        return "welcome";
    }

    @GetMapping("/login") 
    public String login() {
        return "login";  // Return the login view (Thymeleaf template or HTML file)
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User()); // Assuming 'User' is your entity class
        return "signup";
    }

    
    
    @PostMapping("/signup")
    public String signUpUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        // Validate the user's input and create the user account.
        if (userService.createUser(user) != null) {
            // User created successfully, add a success message.
            redirectAttributes.addFlashAttribute("successMessage", "User created! Please log in.");
            return "redirect:/login"; // Redirect to the login page.
        } else {
            // Handle the case where user creation failed, e.g., duplicate username or email.
            // You can add an error message here and return to the signup page.
            redirectAttributes.addFlashAttribute("errorMessage", "User Not created! Please log in.");
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/signup";
        }
    }
}
