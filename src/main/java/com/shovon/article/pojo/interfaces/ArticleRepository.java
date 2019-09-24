package com.shovon.article.pojo.interfaces;


import com.shovon.article.pojo.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
    List<Article> findArticlesByTitleEquals(String title);

    @Query(value = "select * from article", nativeQuery = true)
    List<Article> findByQuery(@Param("id")Long id);
}
