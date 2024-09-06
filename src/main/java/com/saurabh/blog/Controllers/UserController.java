package com.saurabh.blog.Controllers;

import com.saurabh.blog.Pojo.UserData;
import com.saurabh.blog.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserData> getUser(){
        return userService.getUser();
    }

    @GetMapping("/user")
    public UserData getUser(@RequestParam String email){
        return userService.getUserData(email);
    }
    @PostMapping("/user")
    public UserData saveUser(@RequestBody UserData userData){
        return userService.saveUser(userData);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String email){
         userService.deleteUser(email);
    }

    @GetMapping("/test")
    public String test(){
        return "working";
    }
}
