package com.foody.foody.Controllers;


import com.foody.foody.Dtos.AuthResponse;
import com.foody.foody.Dtos.LoginRequest;
import com.foody.foody.Dtos.SignUpRequest;
import com.foody.foody.Dtos.UserResponse;
import com.foody.foody.Services.interfaces.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Authentication")
@RestController
@RequestMapping("/api/v1/auth/")
public class AuthenticationController {

    @Autowired
    AuthService authService;


    @PostMapping("signin")
    public ResponseEntity<AuthResponse> signIn(@RequestBody @Validated  LoginRequest loginRequest){
        return  new ResponseEntity<>(authService.signInUser(loginRequest), HttpStatus.OK);
    }


    @PostMapping("signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody @Validated SignUpRequest signUpRequest){
        return  new ResponseEntity<>(authService.signUpUser(signUpRequest), HttpStatus.CREATED);
    }


}
