package com.shovon.article.controllerclass;

import com.shovon.article.pojo.Article;
import com.shovon.article.pojo.interfaces.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class testController {

    @Autowired ArticleRepository articleRepository;

    @RequestMapping("/test")
    public List<Article> dude(){
        Pageable pageable = PageRequest.of(0, 4, Sort.by("date").descending());
        return articleRepository.findAll(pageable).getContent();
    }

    @RequestMapping("/get_all")
    public List<Article> get_all(){
        List<Article> articleList = new ArrayList<>();
        articleRepository.findAll().forEach(article -> articleList.add(article));
        return articleList;
    }

    @GetMapping("/test/{id}")
    public List<Article> dudeDel(@PathVariable long id){
        System.out.println(id);
        articleRepository.deleteById(id);
        List<Article> articleList = new ArrayList<>();
        articleRepository.findAll().forEach(article -> articleList.add(article));
        return articleList;
    }


}
