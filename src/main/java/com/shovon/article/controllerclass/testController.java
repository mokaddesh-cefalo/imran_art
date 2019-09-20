package com.shovon.article.controllerclass;

import com.shovon.article.pojo.Article;
import com.shovon.article.pojo.interfaces.ArticleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class testController {

    ArticleRepository articleRepository;

    @RequestMapping("/test")
    public List<Article> dude(){
        List<Article> articleList = new ArrayList<>();
        int x = 1;
        Long dude = new Long(x);
        articleRepository.findByIdOK(dude);
        System.out.println("here");
        if(articleList == null) {
            System.out.println("ok");
            articleList = new ArrayList<>();
        }
        return articleList;
    }
}
