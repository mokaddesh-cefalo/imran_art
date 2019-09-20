package com.shovon.article.service;

import com.shovon.article.pojo.Article;
import com.shovon.article.pojo.interfaces.ArticleRepository;
import com.shovon.article.pojo.interfaces.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<Article> addArticle(Article article){
        System.out.println(article.toString());
        articleRepository.save(article);
        return findArticlesByTitleEquals(article.getTitle());
    }

    @Override
    public List<Article> findArticlesByTitleEquals(String title){
        return articleRepository.findArticlesByTitleEquals(title);
    }
}
