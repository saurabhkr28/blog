package com.saurabh.blog.Services;

import com.saurabh.blog.Models.User;
import com.saurabh.blog.Pojo.UserData;
import com.saurabh.blog.Repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserData saveUser(UserData userData){
       User user = convertToModel(userData);
        User newUser = userRepository.save(user);
       UserData newUserdata = convertToData(newUser);
        return newUserdata;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<UserData> getUser() {
        List<User> users = userRepository.findAll();
        List<UserData> userDatas = users.stream().map(u->convertToData(u)).collect(Collectors.toList());
        return userDatas;
    }

    public UserData getUserData(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            UserData userData = convertToData(user.get());
            return userData;
        }
        return null;
    }

    public User getUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElseGet(null);
    }

    public UserData convertToData(User user){
        UserData userData = new UserData();
        BeanUtils.copyProperties(user,userData);
        return userData;
    }

    public User convertToModel(UserData userData){
        User user = new User();
        BeanUtils.copyProperties(userData,user);
        return user;
    }

    @Transactional
    public void deleteUser(String email) {
        userRepository.deleteByEmail(email);
    }
}
