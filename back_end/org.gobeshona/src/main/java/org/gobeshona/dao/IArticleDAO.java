package org.gobeshona.dao;

import java.util.List;
import org.gobeshona.entity.Article;
import org.springframework.data.repository.CrudRepository;

    public interface IArticleDAO 
    {
//    List<Article> getAllArticles();

    List getAllArticles();
    Article getArticleById(int articleId);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
    boolean articleExists(String title, String category);
    }
