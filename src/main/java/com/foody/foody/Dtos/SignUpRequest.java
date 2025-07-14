package com.foody.foody.Dtos;

import jakarta.validation.constraints.NotBlank;

public class SignUpRequest {
    @NotBlank(message = "Please provide email")
    private String email;
    @NotBlank(message = "Please provide password")
     private String password ;
    @NotBlank(message = "Please provide fullName")
     private String fullName;

    public SignUpRequest(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public SignUpRequest() {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
