package com.shovon.article.pojo.interfaces;

import com.shovon.article.pojo.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserById(String userName);
    User save(User user);
}
