package com.saurabh.blog.Services;

import com.saurabh.blog.Models.User;
import com.saurabh.blog.Pojo.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class SignupService {
    @Autowired
    private UserService userService;

    public User signup(SignupRequest signupRequest){
        User user = createUser(signupRequest);
        return userService.saveUser(user);
    }

    public User createUser(SignupRequest signupRequest){
        User user = new User();
        user.setName(signupRequest.getName());
        user.setName(signupRequest.getEmail());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(15,new SecureRandom());
        user.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        return user;

    }
}
