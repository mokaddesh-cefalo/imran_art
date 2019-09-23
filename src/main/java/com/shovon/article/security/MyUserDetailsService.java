package com.shovon.article.security;

import com.shovon.article.pojo.User;
import com.shovon.article.pojo.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userService.findUserById(s);
        user.orElseThrow(() -> new UsernameNotFoundException("User Not found :" + s));
        return user.map(MyUserDetails::new).get();
    }
}
