package org.gobeshona.articles;

import java.util.List;

import org.gobeshona.articles.Articles;

public interface IArticleService {
     List<Articles> getAllArticles();
//     List getAllArticles();
     Articles getArticleById(int articleId);
     boolean addArticle(Articles article);
     void updateArticle(Articles article);
     void deleteArticle(int articleId);
}
