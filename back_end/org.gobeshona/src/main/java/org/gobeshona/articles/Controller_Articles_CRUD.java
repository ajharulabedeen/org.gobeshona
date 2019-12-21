package org.gobeshona.articles;

import org.gobeshona.configs.SpringApplicationContextInterface;
import org.gobeshona.configs.StatusRequestSingleton;
import org.gobeshona.pojos.Articles;
import org.gobeshona.pojos.Articles_Insert;
import org.gobeshona.pojos.StatusRequest;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.gobeshona.configs.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class Controller_Articles_CRUD
        
    {

    public Controller_Articles_CRUD()
        {
        }

        @Autowired
        Services_Articles_CRUD_I bean_services_Articles_CRUD_I;
        
        StatusRequest statusRequest  = StatusRequestSingleton.getStatusRequest();
        
        @RequestMapping( value = "/postArticle", method = RequestMethod.POST)
        public Articles_Insert postArticle(@RequestBody Articles_Insert articlesToPost)
          {
            return bean_services_Articles_CRUD_I.services_PostArticle(articlesToPost);
          }
        
        @RequestMapping( value = "/deleteArticle", method = RequestMethod.DELETE)
        public StatusRequest deleteArticle(@RequestBody Articles articlesToDelete)
          {
            statusRequest.setOperationStatus(bean_services_Articles_CRUD_I.services_ArticleDelete(articlesToDelete));
            return statusRequest;
          }
        
        @RequestMapping( value = "/updateArticle", method = RequestMethod.PUT)
        public StatusRequest updateArticle(@RequestBody Articles articlesToUpdate)
          {
            statusRequest.setOperationStatus(bean_services_Articles_CRUD_I.services_ArticlesUpdate(articlesToUpdate));
            return statusRequest;
          }
        
//      Public (Every one will see)
        @RequestMapping( value = "/getArticlesSummuryWithOutContent", method = RequestMethod.GET)
        public List getArticlesSummuryWithOutContent()
          {
            return bean_services_Articles_CRUD_I.services_ReadAllArticlesWithOutContent();
          }

//      Public (Every one will see) 
        @RequestMapping( value = "/getSpecificArticleDetails/{specificArticleID}", method = RequestMethod.GET)
        public Articles_Insert getSpecificArticle(@PathVariable int specificArticleID)
          {          
              SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
              Session session = sessionFactory.openSession();
              Object o = session.load(Articles_Insert.class, new Integer(specificArticleID));
              Articles_Insert a = (Articles_Insert) o;
              Hibernate.initialize(a);
              session.close();
              sessionFactory.close();
              return a;
          }
    }
