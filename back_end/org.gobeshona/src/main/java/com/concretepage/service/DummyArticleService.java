package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.concretepage.dao.IArticleDAO;
import com.concretepage.entity.Article;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Service
@Component
@Qualifier("dummyService")
public class DummyArticleService implements IArticleService
    {

    @Autowired
    private IArticleDAO articleDAO;

    @Override
    public Article getArticleById(int articleId)
        {
        Article obj = articleDAO.getArticleById(articleId);
        return obj;
        }

    @Override
    public List<Article> getAllArticles()
        {
        System.out.println("Class Name: "+ getClass().toString());
        return articleDAO.getAllArticles();
        }

    @Override
    public synchronized boolean addArticle(Article article)
        {
        if (articleDAO.articleExists(article.getTitle(), article.getCategory()))
          {
            return false;
          } else
          {
            articleDAO.addArticle(article);
            return true;
          }
        }

    @Override
    public void updateArticle(Article article)
        {
        articleDAO.updateArticle(article);
        }

    @Override
    public void deleteArticle(int articleId)
        {
        articleDAO.deleteArticle(articleId);
        }
    }
