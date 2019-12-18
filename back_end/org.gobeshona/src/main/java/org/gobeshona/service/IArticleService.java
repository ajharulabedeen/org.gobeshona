package org.gobeshona.service;

import java.util.List;

import org.gobeshona.entity.Article;

public interface IArticleService {
     List<Article> getAllArticles();
//     List getAllArticles();
     Article getArticleById(int articleId);
     boolean addArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(int articleId);
}
