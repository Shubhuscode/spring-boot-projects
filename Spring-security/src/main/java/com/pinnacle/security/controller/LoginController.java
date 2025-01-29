package com.pinnacle.security.controller;

import com.pinnacle.security.model.User;
import com.pinnacle.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/loginPage")  // Change path here to avoid conflict
    public String showLoginForm() {
        return "login"; // This will render the login.html page
    }

    @PostMapping("/loginPage")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.getUserByUsername(username);
        
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Authentication is successful
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/home"; // Redirect to home page or a secured area
        }
        
        model.addAttribute("error", "Invalid username or password");
        return "login"; // Redirect back to login page with error message
    }
}
