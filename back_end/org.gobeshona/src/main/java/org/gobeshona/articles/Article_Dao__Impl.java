package org.gobeshona.articles;

import org.gobeshona.articles.Articles;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Sajib
 */
@Repository
@Transactional
public class Article_Dao__Impl implements Article_Dao_I 
{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Articles post_Article(Articles articles)
    {
        System.out.println("\n---post_Article---\n");
        entityManager.persist(articles);
        return articles;
    }

    @Override
    public void delete_Article(Long articleId) 
    {
        entityManager.remove(entityManager.find(Articles.class,articleId));
    }

    @Override
    public void edit_Article(Articles articles) 
    {
        entityManager.merge(articles);
    }
    
}//ArticlePrsistence_Impl
