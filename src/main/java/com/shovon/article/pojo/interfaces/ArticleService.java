package com.shovon.article.pojo.interfaces;

import com.shovon.article.pojo.Article;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {
    List<Article> addArticle(Article article);
    List<Article> findArticlesByTitleEquals(String title);
    List<Article> findAll(Pageable pageable);
    List<Article> findAll();
    Long getArticleCount();
    List<Integer> getArticlePageIdList();
    Article findArticleById(long id);
    long articlePerPage();
    void deleteById(long id);
}
