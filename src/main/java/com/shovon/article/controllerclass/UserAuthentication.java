package com.shovon.article.controllerclass;

import com.shovon.article.pojo.User;
import com.shovon.article.pojo.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserAuthentication {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String getLoginDodo(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/register")
    public String adduser(User user) {
        System.out.println(user.toString());
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String getAdduser(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

}
