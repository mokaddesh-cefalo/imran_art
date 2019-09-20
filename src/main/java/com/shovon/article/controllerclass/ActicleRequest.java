package com.shovon.article.controllerclass;

import com.shovon.article.pojo.Article;
import com.shovon.article.pojo.interfaces.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.function.Supplier;

@Controller
@RequestMapping("/article")
public class ActicleRequest {

    @Autowired ArticleService articleService;

    @GetMapping("/add")
    public String addNewArticleGet(Model model){
        model.addAttribute("article", new Article());
        return "addarticle";
    }

    @PostMapping("/add")
    public String addNewArticlePost(Article article){
        List<Article> newArticle = articleService.addArticle(article);
        newArticle.stream().forEach(article1 -> System.out.println(article1.toString()));
        return "redirect:/";
    }
}
