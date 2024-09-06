package com.saurabh.blog.Controllers;

import com.saurabh.blog.Pojo.SignupRequest;
import com.saurabh.blog.Services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody SignupRequest signupRequest){
        signupService.signup(signupRequest);
        return new ResponseEntity<>("Signed Up Successfully",HttpStatus.OK);
    }
}
