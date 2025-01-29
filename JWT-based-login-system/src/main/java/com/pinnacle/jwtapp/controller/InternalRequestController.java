package com.pinnacle.jwtapp.controller;


import com.pinnacle.jwtapp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InternalRequestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TokenService tokenService;

    // A controller endpoint that makes an internal request to the protected endpoint
    @GetMapping("/internal/protected-request")
    public String callProtectedRequest() {
        // Use TokenService to generate a token
        String token = tokenService.getTokenForInternalRequests();

        // Set up the authorization header with the token
        String url = "http://localhost:8080/api/protected";
        String response = restTemplate.getForObject(url, String.class, token);

        return response; // Return the response from the protected endpoint
    }
}
