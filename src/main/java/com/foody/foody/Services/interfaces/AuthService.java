package com.foody.foody.Services.interfaces;

import com.foody.foody.Dtos.AuthResponse;
import com.foody.foody.Dtos.LoginRequest;
import com.foody.foody.Dtos.SignUpRequest;

public interface AuthService {

  public AuthResponse signInUser(LoginRequest loginRequest);
  public AuthResponse signUpUser(SignUpRequest signUpRequest);

}
