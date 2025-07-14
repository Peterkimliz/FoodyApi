package com.foody.foody.Security;

import com.foody.foody.Models.UserModel;
import com.foody.foody.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsImplementation implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserModel> userModel = userRepository.findByEmail(email);
        if (userModel.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(
                userModel.get().getUsername(),
                userModel.get().getPassword(),
                new ArrayList<>()
        );
    }
}
