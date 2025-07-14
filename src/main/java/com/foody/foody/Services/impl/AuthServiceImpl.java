package com.foody.foody.Services.impl;

import com.foody.foody.Dtos.AuthResponse;
import com.foody.foody.Dtos.LoginRequest;
import com.foody.foody.Dtos.SignUpRequest;
import com.foody.foody.Dtos.UserResponse;
import com.foody.foody.Exceptions.FoundException;
import com.foody.foody.Exceptions.NotFoundException;
import com.foody.foody.Models.UserModel;
import com.foody.foody.Repositories.UserRepository;
import com.foody.foody.Security.JwtService;
import com.foody.foody.Services.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public AuthResponse signInUser(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())

            );
            Optional<UserModel> userModel = userRepository.findByEmail(loginRequest.getEmail());
            if (userModel.isEmpty()) {
                throw new NotFoundException("Wrong email or password");
            }
            return constructUser(userModel.get());
        } catch (Exception e) {
            throw new NotFoundException("Wrong email or password");
        }
    }


    @Override
    public AuthResponse signUpUser(SignUpRequest signUpRequest) {
        Optional<UserModel> foundUser = userRepository.findByEmail(signUpRequest.getEmail());
        if (foundUser.isPresent()) {
            throw new FoundException("User with email address already exists");
        }

        UserModel userModel = new UserModel();
        userModel.setEmail(signUpRequest.getEmail());
        userModel.setFullName(signUpRequest.getFullName());
        userModel.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userModel.setCreatedAt(LocalDateTime.now());
        userRepository.save(userModel);
        return constructUser(userModel);
    }


    private AuthResponse constructUser(UserModel foundUser) {
        String token = jwtService.generateToken(foundUser);
        return new AuthResponse(
                token,
                new UserResponse(
                        foundUser.getFullName(),
                        foundUser.getEmail(),
                        foundUser.getId(),
                        foundUser.getCreatedAt()
                )
        );
    }

}
