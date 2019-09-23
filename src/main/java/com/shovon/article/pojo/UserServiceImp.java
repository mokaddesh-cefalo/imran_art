package com.shovon.article.pojo;

import com.shovon.article.pojo.interfaces.UserRepository;
import com.shovon.article.pojo.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired UserRepository userRepository;

    @Override
    public Optional<User> findUserById(String userName){
        return userRepository.findById(userName);
    }
    @Override
    public User save(User user){ return userRepository.save(user); }
}
