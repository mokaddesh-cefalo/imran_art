package com.shovon.article.pojo.interfaces;

import com.shovon.article.pojo.Article;

import java.util.List;

public interface ArticleService {
    List<Article> addArticle(Article article);
    List<Article> findArticlesByTitleEquals(String title);
    Article findArticleById(Long id);
    List<Article> findAll();
}
