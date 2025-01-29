package com.pinnacle.jwtapp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProtectedController {

    // A protected endpoint, only accessible with a valid token
    @GetMapping("/protected")
    public String protectedEndpoint() {
        return "This is a protected endpoint. You have access!";
    }
}

