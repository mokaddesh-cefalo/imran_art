package com.shovon.article.pojo.interfaces;

import com.shovon.article.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
    List<Article> findArticlesByTitleEquals(String title);

    @Query(value = "select * from article", nativeQuery = true)
    List<Article> findByQuery(@Param("id")Long id);
}
