package com.shovon.article.pojo.interfaces;

import com.shovon.article.pojo.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
