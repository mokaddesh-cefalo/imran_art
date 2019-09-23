package com.shovon.article.pojo.interfaces;

import com.shovon.article.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
