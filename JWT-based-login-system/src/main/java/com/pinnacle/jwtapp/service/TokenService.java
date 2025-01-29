package com.pinnacle.jwtapp.service;


import com.pinnacle.jwtapp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private JwtUtil jwtUtil;

    public String getTokenForInternalRequests() {
        // Use a hardcoded user or internal service credentials
        String username = "admin";
        return jwtUtil.generateToken(username);
    }
}
