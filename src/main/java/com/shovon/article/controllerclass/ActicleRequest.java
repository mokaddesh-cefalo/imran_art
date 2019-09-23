package com.shovon.article.controllerclass;

import com.shovon.article.pojo.Article;
import com.shovon.article.pojo.interfaces.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
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
        article.setCreatedBy("fish");
        List<Article> newArticle = articleService.addArticle(article);

        if(newArticle != null)
            newArticle.stream().forEach(article1 -> System.out.println(article1.toString()));

        return "redirect:/";
    }

    @GetMapping("/show/{id}")
    public String showArticle(Model model, @PathVariable(value = "id") Article article){
        model.addAttribute("article", article);
        return "showarticle";
    }

    @GetMapping("/update/{id}")
    public String updateArticle(Model model, @PathVariable(value = "id") Article article){
        System.out.println(article.toString());
        model.addAttribute("article", article);
        return "updatearticle";
    }

    @PostMapping("/update/{id}")
    public String updateArticlePost(Article article){
        System.out.println(article.toString());
        articleService.addArticle(article);
        return "redirect:/article/show/" + article.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable long id){
        System.out.println(id);
        articleService.deleteById(id);
        List<Article> articleList = new ArrayList<>();
        articleService.findAll().forEach(article -> articleList.add(article));
        return "redirect:/articlelist";
    }
}
