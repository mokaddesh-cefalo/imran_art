package com.shovon.article.service;

import com.shovon.article.pojo.Article;
import com.shovon.article.pojo.interfaces.ArticleRepository;
import com.shovon.article.pojo.interfaces.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    public static long numberOfArtileInAPage = 4;

    @Override
    public List<Article> addArticle(Article article){
        if(article.getId() == null) article.setDate(new Date().toString());
        System.out.println(article.toString());
        articleRepository.save(article);
        return findArticlesByTitleEquals(article.getTitle());
    }

    @Override
    public List<Article> findArticlesByTitleEquals(String title){
        return articleRepository.findArticlesByTitleEquals(title);
    }

    @Override
    public List<Article> findAll(Pageable pageable){
        return articleRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Article> findAll(){
        List<Article> articleList = new ArrayList<>();
        articleRepository.findAll().forEach(article -> articleList.add(article));
        return articleList;
    }

    @Override
    public Long getArticleCount(){
        return articleRepository.count();
    }

    public List<Integer> getArticlePageIdList(){

        Long articleCount = getArticleCount();
        List<Integer> listOfpage = new ArrayList<>();

        int currentCount = 0, addPageId = 0, articlePerPage = 4;
        while (articleCount >= currentCount){
            currentCount += articlePerPage;
            listOfpage.add(addPageId++);
        }

        return listOfpage;
    }

    @Override
    public long articlePerPage(){
        return numberOfArtileInAPage;
    }

    @Override
    public Article findArticleById(long id){
        return articleRepository.findById(id).get();
    }
}
