package com.saurabh.blog.Services;

import com.saurabh.blog.Models.User;
import com.saurabh.blog.Pojo.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(LoginRequest loginRequest){
        String email = loginRequest.getEmail();
        User user = userService.getUser(email);
        String password = loginRequest.getPassword();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(bCryptPasswordEncoder.matches(password, user.getPassword())){
            return jwtUtil.generateToken(email);
        }
        return "Invalid email or password";
    }
}
