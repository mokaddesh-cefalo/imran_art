package com.shovon.article.pojo.interfaces;

import com.shovon.article.pojo.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findArticlesByTitleEquals(String title);
}
