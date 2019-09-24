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

    @Autowired
    UserRepository userRepository;

    User addUser(String userGson){
        Gson gson = new Gson();
        User newUser = null;

        try {
            newUser = gson.fromJson(userGson, User.class);
        }catch (JsonParseException e){
           e.fillInStackTrace();
        }

        System.out.println(newUser.toString());
        return userRepository.save(newUser);
    }

    User addUser(User newUser){
        if(newUser.getUserName() == null || newUser.getUserName().equals("")) return null;
        if(newUser.getPassword() == null || newUser.getPassword().equals("")) return null;
        return userRepository.save(newUser);
    }

    List<User> getAlluser(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(x -> users.add(x));
        return users;
    }
}
