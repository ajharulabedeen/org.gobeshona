package com.concretepage.client;

import com.concretepage.MyApplication;
import com.concretepage.dao.ArticleDAO;
import com.concretepage.dao.Article_I_CRUD_Repo;
import com.concretepage.entity.Article;
import com.concretepage.service.ArticleService;
import com.concretepage.service.IArticleService;
import java.util.List;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit4.SpringRunner;

//import com.infotech.book.ticket.app.entities.Ticket;

@RunWith(SpringRunner.class)
@DataJpaTest
//@Transactional
@SpringApplicationConfiguration(classes = MyApplication.class)
//@BootstrapWith(SpringBootTestContextBootstrapper.class)
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
//public class TicketBookingDaoTest extends TestCase
public class TicketBookingDaoTest 
    {
    
    @Autowired
    private Article_I_CRUD_Repo article_I_CRUD_Repo;
    
//    @Autowired
//    private ArticleDAO articleDAO;
    
//    @Qualifier("dummyService")
//    @Autowired
//    IArticleService articleService;
    
    @Test
    public void testSaveTicket()
        {        
//            System.out.println("\n\n\n\n\n");
            ArticleDAO articleDAO = new ArticleDAO();
//            Article a = new Article("a","b");
////            articleDAO.addArticle(a);
////            article_I_CRUD_Repo.save(a);
//            
//            List l = articleDAO.getAllArticles();
            List l = article_I_CRUD_Repo.findAll();
//            List l = articleService.getAllArticles();
//            System.out.println("L : "+l.size());
//            List l = article_I_CRUD_Repo.findAll();
            System.out.println("L : "+l.size());
            
            System.out.println("\n\n\n\n\n");
        }
    }
