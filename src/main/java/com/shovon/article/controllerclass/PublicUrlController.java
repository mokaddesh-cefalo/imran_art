package com.shovon.article.controllerclass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class PublicUrlController {

    @GetMapping
    public String check() {
        return "welcome";
    }
}
