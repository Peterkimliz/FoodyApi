package com.foody.foody.Dtos;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "Please provide email")
    private String email;
    @NotBlank(message = "Please provide password")
    private String password ;


    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public LoginRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
