package com.smartclinic.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String generateToken(String data) {
        // Example logic to generate a token
        return "token-" + data.hashCode();
    }

    public boolean validateToken(String token) {
        // Example logic to validate a token
        return token != null && token.startsWith("token-");
    }
}
