package com.gobeshonabd.users;

import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.configs.MapSingleton;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import java.util.List;
import com.gobeshonabd.pojos.Users_Public_View;
import com.gobeshonabd.pojos.Users;
import com.gobeshonabd.configs.SpringApplicationContextInterface;
import com.gobeshonabd.configs.StatusRequestSingleton;
import com.gobeshonabd.pojos.StatusRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;


@RestController
public class Controllers_Users 
        implements SpringApplicationContextInterface
    {
        
    @Autowired
    Services_Users_CRUD_I bean_services_Users_CRUD_I;
        
        StatusRequest statusRequest  = StatusRequestSingleton.getStatusRequest();
        
        @RequestMapping( value = "/userRegistration", method = RequestMethod.POST)
        public StatusRequest userRegistration(@RequestBody Users userToInsert)
            {
                statusRequest.setOperationStatus(bean_services_Users_CRUD_I.services_insertUser(userToInsert));
                return statusRequest;
            }
        
        @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
        public StatusRequest userDeletion(@RequestBody Users userToDelete)
            {
//***************** inside mentod: Test Code **************************************************
                System.out.println(" \n UserID: " + userToDelete.getUserID());
                System.out.println(" Email : " + userToDelete.getEmailID());
                System.out.println(" Password : " + userToDelete.getPassword());
                System.out.println(" After setting Password : " + userToDelete.getPassword());
                System.out.println(" Fname: " + userToDelete.getUserFirstName());
//***************** inside mentod: Test Code **************************************************

                statusRequest.setOperationStatus(bean_services_Users_CRUD_I.services_deleteUser(userToDelete));
                return statusRequest;
            }
        
//        ******************************** Start Test ******************************** 
        @RequestMapping(value = "/deleteSpecificUser/{id}", method = RequestMethod.DELETE)
//        @RequestMapping(value = "/deleteSpecificUser", method = RequestMethod.DELETE)
        public String deleteSpecificUser(@PathVariable int id)
//        public String deleteSpecificUser( @RequestParam int id )
            {            
                Configuration cfg = new Configuration();
                cfg.configure("hibernate.cfg.xml");

                SessionFactory factory = cfg.buildSessionFactory();
                Session session = factory.openSession();

                Users users = new Users();
                
                Object o = session.get(users.getClass(), new Integer(id));
                Users v = (Users) o;
                Transaction tx = session.beginTransaction();
                session.delete(v);
                tx.commit();

                session.close();
                System.out.println("One To Many is Done for deleting..!!");
                factory.close();
//                return bean_services_Users_CRUD_I.services_deleteUser(v);
                return "Delete Success";
            }
//        ******************************** End Test ******************************** 
        
        
        @RequestMapping( value = "/updateUser", method = RequestMethod.PUT)
        public StatusRequest userUpdate(@RequestBody Users userToUpdate)
            {
//***************** Test Code **************************************************
//                System.out.println(" \n UserID: " + userToUpdate.getUserID());
//                System.out.println(" Email : " + userToUpdate.getEmailID());
//                System.out.println(" Password : " + userToUpdate.getPassword());
//                userToUpdate.setPassword("234235");
//                System.out.println(" After setting Password : " + userToUpdate.getPassword());
//                System.out.println(" Fname: " + userToUpdate.getUserFirstName());
//***************** Test Code **************************************************

                statusRequest.setOperationStatus(bean_services_Users_CRUD_I.services_updateUser(userToUpdate));
                return statusRequest;
            }
        
        @RequestMapping(value = "/userProfileDetails/{specificUserID}", method = RequestMethod.GET)
        public List<Users> userProfileDetails(@PathVariable int specificUserID)
            {        
            
            //Have to change, left as font end has developped as it will reteun a list. But Lazy loading problem has sloved.
                System.out.println("\n public List<Users> userProfileDetails(@PathVariable int specificUserID) \n");
//                
//                SessionFactory factory = HibernateUtil.getSessionFactory();
//                Session session = factory.openSession();
//
//                Query qry = session.createQuery(" from Users u where u.userID ="+ specificUserID );
//                List<Users> l = qry.list();
//                session.close();//Here is problem, if Session is closed then unable to back data.
//                factory.close();
//                return l;
                return bean_services_Users_CRUD_I.services_getSpecificUserData(specificUserID);
            }
        
//        public
        @RequestMapping(value = "/showUsersPublicData", method = RequestMethod.GET)
        public List<Users_Public_View> showUsersPublicData()
            {        
                return bean_services_Users_CRUD_I.services_getAllUsersDataToShowPublic();
            }
        
        @RequestMapping(value = "/checkUserId", method = RequestMethod.POST)
        public Map checkUserId(@RequestParam String uname, @RequestParam String pass)
            {
                System.out.println("Uname : "+ uname);
                System.out.println("Pass: "+ pass);
                Map map = MapSingleton.getMap();
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();
                Criteria criteria = session.createCriteria(Users.class);
                Criterion searchUname = Restrictions.eq("emailID", uname);
                Criterion searchPass = Restrictions.eq("Password", pass);
                criteria.add(searchUname);
                criteria.add(searchPass);
                Users users_obj = (Users) applicationContext.getBean("pojoUsers");
                List<Users> l = criteria.list();
                if(l.isEmpty() == false)
                  {
                    users_obj = (Users) l.get(0);
                    map.put("userid", users_obj.getUserID());
                    map.put("status", "ok");
                  }
                if(l.isEmpty())
                  {
                    map.put("status", "fail");
                  }
                session.close();
                sessionFactory.close();
                return map;
            }
        
//        Start : Test Join table
        @RequestMapping(value = "/joinTable", method = RequestMethod.GET)
        public List joinTable()
            {
                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
                Session session = sessionFactory.openSession();
                
                
//                select employee.id, employee.surname, subject.name from Employee employee
//                join employee.subject subject
                
//                String qryString = " SELECT "
//                        + " articles.articleSubject, "//0
//                        + "articles.articleDate, "//1
//                        + "users.userFirstName, "//2
//                        + "users.userLastName, "//3
//                        + "users.joinDate "//4
//                        + ""
//                        + " FROM Articles_Insert articles,Users users "
//                        + " where articles.userID_articleByUser = users.userID";
//                
                String qryString = " SELECT "
                        + "  "//0
                        + " users.userFirstName, "//2
                        + " users.userLastName, "//3
                        + " users.joinDate, "//4
                        + " articles "
                        + " FROM Articles_Insert articles,Users users "
                        + " where articles.userID_articleByUser = users.userID";
                
                Query qry = session.createQuery(qryString );
                List l = qry.list(); 
//                List l2 = new ArrayList();
//                Iterator iterator = l.iterator();
//                while (iterator.hasNext())
//                  {
//                    Object[] next = (Object[]) iterator.next();
//                    
//                    Map map = new HashMap();
//                    map.put("firstName", next[2]);
//                    map.put("lastName", next[3]);
//                    map.put("joinDate", next[4]);
//                    map.put("articleSubject", next[0]);
//                    map.put("articleDate", next[1]);
//                    l2.add(map);
//                    
//                  }
                session.close();
                sessionFactory.close();
                return l;
            }
//        End : Test Join table        
        
        
//        @RequestMapping(value = "/getUserID_Of_LoggedUser", method = RequestMethod.GET)
//        public String getUserID_Of_LoggedUser()
//            {        
//                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//                String name = auth.getName(); //get logged in username
//
////                Not better Enginererd
//                SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//                Session session = sessionFactory.openSession();
//
//                Criteria criteria = session.createCriteria(Users.class);
//                Criterion search = Restrictions.eq("emailID", name);
//                criteria.add(search);
//
//                List<Users> l = criteria.list();
//                session.close();
//                sessionFactory.close();
//
//                Users users_obj = (Users) applicationContext.getBean("pojoUsers");
//
//                if (l.isEmpty() == false)
//                  {
//                    users_obj = l.get(0);
//                  }
////                Not better Enginererd                
//
//                return Integer.toString(users_obj.getUserID());
//            }
//        
        
        
//***************** Start Test Code **************************************
//        @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
//        public List testAll( @PathVariable int id )
//            {  
//                SessionFactory factory = HibernateUtil.getSessionFactory();
//                Session session = factory.openSession();
//
////                Query qry = session.createQuery(" Select u.articleByUser from Users u where u.userID ="+ id );
//                Query qry = session.createQuery(" from Users u where u.userID ="+ id );
////                Query qry = session.createQuery(" from Users u ");
//                List l = qry.list();
//                return l;
//            }
//        @RequestMapping(value = "/testDelete/{id}", method = RequestMethod.DELETE)
//        public String testDelete( @PathVariable int id )
//            {            
////  not working          start ***************************************************************************
//                Configuration cfg = new Configuration();
//                cfg.configure("hibernate.cfg.xml");
//                SessionFactory factory = cfg.buildSessionFactory();
//                Session session = factory.openSession();
//                try
//                  {
//                    Query qry = session.createQuery(" Select u.articleByUser from Users u where u.userID =" + id);
//                    List l = qry.list();
//
//                    Iterator iterator = l.iterator();
//
//                    Transaction tx = session.beginTransaction();
//                    while (iterator.hasNext())
//                      {
//                        try
//                          {
//                            Articles articles = (Articles) iterator.next();
//                            System.out.println("\n Article Delete : " + articles.getArticleID());
//
//                            Query qryInner = session.createQuery(" Select a.articlesComments from Articles a ");
//                            List listInner = qryInner.list();
//                            Iterator iteratorIn = listInner.iterator();
//                            while (iteratorIn.hasNext())
//                              {
//
//                                ArticlesComments articles_Comment = (ArticlesComments) iteratorIn.next();
//                                System.out.println(" \n comnt Article id : " + articles_Comment.getArticleID());
//                                session.delete(articles_Comment);
//                              }
//                            session.delete(articles);
//                          } 
//                        catch (Exception e)
//                          {
//                            e.printStackTrace();
//                            System.out.println("........................");
//                          }
//                      }
//                    tx.commit();
//                    session.close();
//                    System.out.println("One To Many is Done for deleting..!!");
//                    factory.close();
//                  } 
//                catch (Exception e)
//                  {
//                    System.out.println("\n Delete not done....! \n");
//                    e.printStackTrace();
//                    System.out.println("");
//                    System.out.println("");
//                    System.out.println("");
//                    session.close();
//                    factory.close();
//                    System.out.println("..............................................................");
//                  }
//// not working            end ***************************************************************************                
//                
//
////......working...start ***************************************************************************            
////                 Configuration cfg = new Configuration();
////                cfg.configure("hibernate.cfg.xml");
////                  cfg = new Configuration();
////                cfg.configure("hibernate.cfg.xml");
////
//////                SessionFactory factory = cfg.buildSessionFactory();
//////                Session session = factory.openSession();
////                 factory = cfg.buildSessionFactory();
////                 session = factory.openSession();
////                
////                Object o = session.get(Users.class, new Integer(id));
////                Users v = (Users) o;
////                
////                Transaction tx = session.beginTransaction();
////                session.delete(v);
////                tx.commit();
////
////                session.close();
////                System.out.println("One To Many is Done for deleting..!!");
////                factory.close();
////......working...end ***************************************************************************                                
//
//            return "delete Code";
//                
//            }
//        
//         @RequestMapping(value = "/testOneTomanyinsert", method = RequestMethod.POST)
//         public String OneToManyInsert( )
//             {
//             
//                 Configuration cfg = new Configuration();
//                 cfg.configure("hibernate.cfg.xml");
//
//                 SessionFactory factory = cfg.buildSessionFactory();
//                 Session session = factory.openSession();
//                 
//                 Users users = new Users();
//                 users.setUserID(12);
//                 users.setEmailID("gobeshonabd@gmail.com");
//                 users.setPassword("gobeshonabd@gmail.com");
//                 
//                 Articles a1 = new Articles();
//                 Articles a2 = new Articles();
//                 Articles a3 = new Articles();
//                 
//                 Set set = new HashSet();
//                 set.add(a1);
//                 set.add(a2);
//                 set.add(a3);
//                 users.setArticleByUser(set);
//                 
//                 try
//                   {
//                       Transaction tx = session.beginTransaction();
//                       session.save(users);
//                       tx.commit();
//                       session.close();
//                       System.out.println("One To Many is Done..!!");
//                       factory.close();
//                   } 
//                 catch (Exception e)
//                   {
//                       System.out.println("\nprinting stack trace.......\n");
//                        e.printStackTrace();
//                       session.close();
//                       System.out.println("One To Many is Done..!!");
////                       factory.close();
//                   }
////                 Transaction tx = session.beginTransaction();
////                 session.save(users);
////                 tx.commit();
////                 session.close();
////                 System.out.println("One To Many is Done..!!");
////                 factory.close();
//                 
//                return "Inside Insert Operation....!";
//             }
//        
//***************** End Test Code **************************************

    }
