package com.gobeshonabd.users;

import com.gobeshonabd.configs.Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl;
import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.User_Roles;
import com.gobeshonabd.pojos.Users;
import com.gobeshonabd.pojos.Users_Public_View;
import com.gobeshonabd.pojos.Users_Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAO_Users_CRUD_Impl implements
        DAO_Users_CRUD_I,
        Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl
    {

    public DAO_Users_CRUD_Impl()
        {

        }

    @Override
    public String dao_insertUser(Users usersBeanToInsert, Users_Security users_Security_to_insert ,User_Roles user_Roles_insert)
        {
//        return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Insert(usersBeanToInsert);

        String dataInsertionStatus = " public String dao_Generel_Insert(Object objectToInsert) ";

        SessionFactory sessionFactory = null;
        Session session = null;

        try
          {
            sessionFactory = HibernateUtil.getSessionFactory();

            session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            
            session.save(usersBeanToInsert);
            session.save(users_Security_to_insert);
            session.save(user_Roles_insert);
          System.out.println("\nBefore Commit : \n"+usersBeanToInsert.getUserID());            
            tx.commit();
          System.out.println("\nAfter Commit : \n"+usersBeanToInsert.getUserID());
            dataInsertionStatus = "successInsert";
          } 
        catch (Exception e)
          {
            dataInsertionStatus = "failInsert";
            System.out.println("\n\n User Insertion Error : " + e.getClass());
            System.out.println();
            e.printStackTrace();
            System.out.println();
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++ User  Insert error ++++++++++++++++++++++++++++++++++++++++");
          } finally
          {
            session.close();
            sessionFactory.close();
            System.out.println("++++++++++++++++++++++++++++++  User Insert Finished+++++++++++++++++++++++++++++++++++++++");
          }

        return dataInsertionStatus;

        }

    @Override
    public String dao_deleteUser(Users usersBeanToDelete)
        {
        return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Delete(usersBeanToDelete);
        }

    @Override
    public String dao_updateUser(Users usersBeanToUpdate, User_Roles user_Role_update)
        {
//        return bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_Update(usersBeanToUpdate);

        String dataUpdateStatus;

        SessionFactory factory = null;
        Session session = null;

        try
          {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();

            Transaction tx = session.beginTransaction();
            session.update(usersBeanToUpdate);
//            session.update(user_Role_update);
            tx.commit();

            dataUpdateStatus = "successUpdate";
          } 
        catch (Exception e)
          {
            dataUpdateStatus = "failUpdate";
            System.out.println("\n\n User Update Error : " + e.getClass());
            e.printStackTrace();
            System.out.println();
            System.out.println();
          } finally
          {
            session.close();
            factory.close();
            System.out.println("\n+++++++++++++++++++++++++ User Update finish +++++++++++++++++++++++++ \n");
          }

        return dataUpdateStatus;

        }

    @Override
    public List<Users> dao_getSpecificUserData(int userID)
        {

        System.out.println("\n public List<Users> dao_getSpecificUserData(int userID) \n");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Query qry = session.createQuery(" from Users u where u.userID =" + userID);
        List<Users> l = qry.list();
        session.close();    //If session is closed, then unable to return data, lazy loading problem.
        sessionFactory.close();
        return l;

//        SessionFactory sessionFactory = null;
//        Session session = null;
//        List<Users> usersToShow = null;
//
//        try
//          {
//            sessionFactory = HibernateUtil.getSessionFactory();
//            session = sessionFactory.openSession();
//
//            Query qry = session.createQuery(" from Users u where u.userID =" + userID);
//            usersToShow = qry.list();
//            
//          } 
//        catch (Exception e)
//          {
//              System.out.println("\n Error happened in reading specific useer data.\n");
//              e.printStackTrace();
//              System.out.println("\n\n");
//          }
//        
//        finally
//          {
//            session.close();
//            sessionFactory.close();
//          }
//        return usersToShow;
        }

    @Override
    public List<Users_Public_View> dao_getAllUsersDataToShowPublic()
        {
        String query = "Select "
                + " user.userID, "//0
                + " user.userFirstName, "//1
                + " user.userLastName, "//2
                + " user.InterestedFields, "//3
                + " user.joinDate, "//4
                + " user.skills,"//5
                + " user.communicationInterest, "//6
                + " user.totalArticles, "//7
                + " user.totalQuestions, "//8
                + " user.totalUpVote, "//9
                + " user.totalDownVote "//10
                + " from Users user ";

        List<Users_Public_View> users_Public_View = new ArrayList<Users_Public_View>();
        List temlList = bean_generel_Insert_Update_Delete_SelectAll_I.dao_Generel_SelectAll(query);
        Iterator iterator = temlList.iterator();
        while (iterator.hasNext())
          {
            Object[] obj = (Object[]) iterator.next();

//              0   int userID
            int userID = Integer.parseInt(obj[0].toString());
//              1   String userFirstName
            String userFirstName = obj[1].toString();
//              2   String userLastName              
            String userLastName = obj[2].toString();
//              3   String InterestedFields
            String InterestedFields = obj[3].toString();
//              4   String joinDate 
            String joinDate = obj[4].toString();
//              5   String skills 
            String skills = obj[5].toString();
//              6   int communicationInterest
            int communicationInterest = Integer.parseInt(obj[6].toString());
//              7   int totalArticles  
            int totalArticles = Integer.parseInt(obj[7].toString());
//              8   int totalQuestions
            int totalQuestions = Integer.parseInt(obj[8].toString());
//              9   float totalUpVote              
            float totalUpVote = Float.parseFloat(obj[9].toString());
//              10  float totalDownVote              
            float totalDownVote = Float.parseFloat(obj[10].toString());

            users_Public_View
                    .add(new Users_Public_View(
                            userID, //0
                            userFirstName, //1
                            userLastName, //2
                            InterestedFields, //3
                            joinDate, //4
                            skills, //5
                            communicationInterest, //6
                            totalArticles, //7
                            totalQuestions, //8
                            totalUpVote, //9
                            totalDownVote //10
                    ));

          }
        return users_Public_View;
        }
    }
