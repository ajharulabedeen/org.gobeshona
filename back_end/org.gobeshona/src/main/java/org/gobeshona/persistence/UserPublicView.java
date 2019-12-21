/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gobeshona.persistence;

import org.gobeshona.configs.HibernateUtil;
import org.gobeshona.configs.SpringApplicationContextInterface;
import org.gobeshona.pojos.Users;
import org.gobeshona.pojos.Users_Public_View;
import java.util.List;
import static java.util.Spliterators.iterator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dell-3460
 */
//@RestController
public class UserPublicView implements SpringApplicationContextInterface
    {

//    @RequestMapping("/get/{userID}")
//    public Users_Public_View userPublicViewByID(@PathVariable int userID)
    public Users_Public_View userPublicViewByID(int userID)
        {
        List userListAfterSearch_obj_list = getUserSearchList(userID);
//        Users_Public_View users_Public_View = (Users_Public_View) applicationContext.getBean("pojoUsers_Public_View");
        Users_Public_View users_Public_View = new Users_Public_View();
        System.out.println("users_Public_View" + users_Public_View);
        if (userListAfterSearch_obj_list.isEmpty() == false)
          {
            Object[] userSearch_Obj = (Object[]) userListAfterSearch_obj_list.get(0);

            users_Public_View.setUserID(Integer.parseInt(userSearch_Obj[0].toString()));// 0. int userID
            users_Public_View.setUserFirstName(userSearch_Obj[1].toString()); //    1. String userFirstName,   
            users_Public_View.setUserLastName(userSearch_Obj[2].toString());//   2. String userLastName
            users_Public_View.setInterestedFields(userSearch_Obj[3].toString());//, //    3. String InterestedFields
            users_Public_View.setJoinDate(userSearch_Obj[4].toString());//, //    4. String joinDate
            users_Public_View.setSkills(userSearch_Obj[5].toString());//, //    5. String skills
            users_Public_View.setCommunicationInterest(Integer.parseInt(userSearch_Obj[6].toString()));//, //  6. int communicationInterest
            users_Public_View.setTotalArticles(Integer.parseInt(userSearch_Obj[7].toString()));//, //  7. int totalArticles
            users_Public_View.setTotalQuestions(Integer.parseInt(userSearch_Obj[8].toString()));//, //  8. int totalQuestions
            users_Public_View.setTotalUpVote(Float.parseFloat(userSearch_Obj[9].toString()));//, //  9. float totalUpVote
            users_Public_View.setTotalDownVote(Float.parseFloat(userSearch_Obj[10].toString()));////  10. float totalDownVote 
          }
        if (userListAfterSearch_obj_list.isEmpty())
          {
            users_Public_View = null;
          }

        return users_Public_View;
        }

    private List getUserSearchList(int userID)
        {
        SessionFactory sessionFactory = null;
        Session session = null;
        List getSearchedUserData = null;

        try
          {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(Users.class);

            ProjectionList projList = Projections.projectionList();
            projList.add(Projections.groupProperty("userID"));          //0
            projList.add(Projections.groupProperty("userFirstName"));   //1
            projList.add(Projections.groupProperty("userLastName"));    //2
            projList.add(Projections.groupProperty("InterestedFields"));//3
            projList.add(Projections.groupProperty("joinDate"));        //4
            projList.add(Projections.groupProperty("skills"));          //5
            projList.add(Projections.groupProperty("communicationInterest"));//6
            projList.add(Projections.groupProperty("totalArticles"));       //7
            projList.add(Projections.groupProperty("totalQuestions"));      //8
            projList.add(Projections.groupProperty("totalUpVote"));         //9
            projList.add(Projections.groupProperty("totalDownVote"));       //10
            criteria.setProjection(projList);

            Criterion userFirstNameCriterion = Restrictions.eq("userID", userID);
            criteria.add(userFirstNameCriterion);
            getSearchedUserData = criteria.list();
          } 
        catch (Exception e)
          {
            e.printStackTrace();
            System.out.println();
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++ Error getting user search data ++++++++++++++++++++++++++++++++++++++++");
          } 
        finally
          {
            session.close();
            sessionFactory.close();//may not work, have to test.
            System.out.println("++++++++++++++++++++++++++++++  end getting user search data +++++++++++++++++++++++++++++++++++++++");
          }

        return getSearchedUserData;
        }

    }
