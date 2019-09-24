package com.shovon.article.service;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.shovon.article.pojo.User;
import com.shovon.article.pojo.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired UserRepository userRepository;

    public User save(User newUser){
        return userRepository.save(newUser);
    }

    public List<User> getAlluser(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(x -> users.add(x));
        return users;
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName).get();
    }
}
