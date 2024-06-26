package com.dmrs.demo.Auth.authentication;

public record LoginDTO(String username, String password) {
    public LoginDTO {
        if(username == null || username.isBlank() || password == null || password.isBlank()){
            throw new IllegalArgumentException("Username and password cannot be null or empty");
        }
    }
}
