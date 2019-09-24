package com.shovon.article.service;


import com.shovon.article.pojo.User;
import com.shovon.article.pojo.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUserName(s);
        user.orElseThrow(() -> new UsernameNotFoundException("NOt found :" + s));
        return user.map(MyUserDetails::new).get();
    }
}
