package com.foody.foody.Services.impl;

import com.foody.foody.Exceptions.NotFoundException;
import com.foody.foody.Models.UserModel;
import com.foody.foody.Repositories.UserRepository;
import com.foody.foody.Services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public UserModel getUserById(Long id) {
        Optional<UserModel> userModelOptional=userRepository.findById(id);
        if(userModelOptional.isEmpty()){
            throw  new NotFoundException("User Not Found");
        }
        return userModelOptional.get();
    }
}
