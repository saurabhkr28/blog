package com.saurabh.blog.Controllers;

import com.saurabh.blog.Pojo.LoginRequest;
import com.saurabh.blog.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }
}
