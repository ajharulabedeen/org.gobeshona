package org.gobeshona.article_test;


import org.gobeshona.articles.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
///**
// *
// * @author Sajib
// */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_ArticlePersistence 
{
    @Autowired
    Article_Dao_I articlePersistence_I;
//
//    
    public Test_ArticlePersistence() {
    }
//    
    @Test
    public void test_post_Article() {
//        Articles articles = new Articles(15,"articleSubject", "articleContent", "articleType");
        Articles articles = new Articles("articleSubject", "articleContent", "articleType", Integer.MIN_VALUE);
        articlePersistence_I.post_Article(articles);
    }
//    
////    @Test
//    public void test_delete_Article()
//    {
//        Long articleId = 3L;
//        articlePersistence_I.delete_Article(articleId);
//    }
//    
//    @Test
//    public void test_edit_Article()
//    {
//       Articles articles = new Articles(4L,"Abedeen", "sajib", "momo");
//       articlePersistence_I.edit_Article(articles);
//
//    }
//
//
}//Test_ArticlePersistence
