package com.foody.foody.Dtos;

public class AuthResponse {
    private String token;
    private UserResponse data;

    public AuthResponse(String token, UserResponse data) {
        this.token = token;
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserResponse getData() {
        return data;
    }

    public void setData(UserResponse data) {
        this.data = data;
    }
}
