package com.shovon.article.controllerclass;

import com.shovon.article.pojo.Article;
import com.shovon.article.pojo.User;
import com.shovon.article.pojo.interfaces.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class PublicUrlController {

    @Autowired ArticleService articleService;

    @GetMapping("/articlelist")
    public String check(Model model, @RequestParam(value = "pagenumber", defaultValue = "0") int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, (int)articleService.articlePerPage(), Sort.by("date").descending());

        model.addAttribute("articles", articleService.findAll(pageable));
        model.addAttribute("pages", articleService.getArticlePageIdList());
        model.addAttribute("currentPage", pageNumber);

        return "articlelist";
    }

    @GetMapping
    public String welcome() {
        return "welcome";
    }
}
