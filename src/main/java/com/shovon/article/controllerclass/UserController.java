package com.shovon.article.controllerclass;

import com.shovon.article.pojo.User;
import com.shovon.article.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserController {

    @Autowired UserService userService;

    @PostMapping
    public String save(User user){
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping
    public String getRegistrationPage(){
        return "register";
    }
}
