package com.gobeshonabd.voting;

import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.Users;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import static com.gobeshonabd.configs.SpringApplicationContextInterface.applicationContext;

public class DAO_Generel_Vote_Save_Read_Impl
        implements DAO_Generel_Vote_Save_Read_I
    {

    public DAO_Generel_Vote_Save_Read_Impl()
        {
        }

    
    /**
     * uIDcIDvValue
     *  it will give values of userID,contentID and voteValue.
     *
     * fieldName_uIDcIDvValue 
     * it will give values of userID,contentID and
     * voteValue property name means the name of the field. 1. userID 2.
     * contentID 3. voteValue
     */
    @Override
    public List dao_generel_vote_voteReader( List<Integer> uIDcIDvValue, List<String> fieldName_uIDcIDvValue, Object voteClassObject)
        {
            /**
             * uIDcIDvValue
             *      it will give values of userID,contentID and voteValue.
             * 
             * fieldName_uIDcIDvValue
             *      it will give values of userID,contentID and voteValue 
             *      property name means the name of the field.
             * 1. userID 
             * 2. contentID
             * 3. voteValue
             */
            SessionFactory sessionFactory = null;
            Session session  = null;
            List getVoteData = null;
            
            try
              {
//                test
                  System.out.println("");
                  System.out.println("Genrel Vote read : Printing Field names  and their values::");
                  System.out.println("Class Name : "+voteClassObject.getClass().toString());
                  System.out.println("index 0 >> field:"+fieldName_uIDcIDvValue.get(0).toString()+" >> value :"+uIDcIDvValue.get(0));
                  System.out.println("index 1 >> field:"+fieldName_uIDcIDvValue.get(1).toString()+" >> value :"+uIDcIDvValue.get(1));
                  System.out.println("index 0 >> field:"+fieldName_uIDcIDvValue.get(2).toString()+" >> value :"+uIDcIDvValue.get(2));
                  System.out.println("");
//                test
                
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
                Criteria criteria = session.createCriteria(voteClassObject.getClass());
                
//     ******************************* No need   *******************************
//                criteria.add(Restrictions.eq(fieldName_uIDcIDvValue.get(0), new Integer(uIDcIDvValue.get(0))) );
//                criteria.add(Restrictions.eq(fieldName_uIDcIDvValue.get(1), new Integer(uIDcIDvValue.get(1))) );
//                criteria.add(Restrictions.eq(fieldName_uIDcIDvValue.get(2), new Integer(uIDcIDvValue.get(2))) );
//     ******************************* No need   *******************************


                criteria.add( Restrictions.eq(fieldName_uIDcIDvValue.get(0).toString(), uIDcIDvValue.get(0)) )
                        .add( Restrictions.eq(fieldName_uIDcIDvValue.get(1).toString(), uIDcIDvValue.get(1)) );
//                        .add( Restrictions.eq(fieldName_uIDcIDvValue.get(2).toString(), uIDcIDvValue.get(2)) );
                
                
                getVoteData = criteria.list();
//                test
                    if( getVoteData.isEmpty() )
                      {
                          System.out.println("Genrel Vote read :");
                          System.out.println("No stored vote found");
                          System.out.println("getVoteData count : "+getVoteData.size());
                          System.out.println("\n");
                      }
                     System.out.println("getVoteData count : "+getVoteData.size());
//                test
                
              } 
            catch (Exception e)
              {
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ Genrel : Error getting vote data ++++++++++++++++++++++++++++++++++++++++");
              }
            finally
              {
                session.close();
                sessionFactory.close();//may not work, have to test.
                System.out.println("++++++++++++++++++++++++++++++ Genrel : end getting vote data +++++++++++++++++++++++++++++++++++++++");
              }

            return getVoteData;
            
        }
    
    
      /**
     * fieldNameList 0.contentID; 1.upVote; 2. DownVote.
     * it will return these three fled of any class
     * that will be passed as arg.
     */
    @Override
    public List dao_generel_vote_contentReader(int contentID, String contentIDname, Object contentClass)
        {
            
            SessionFactory sessionFactory = null;
            Session session     = null;
            List getContentData = null;
            
            try
              {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                
//as to read and load only particular field have to use inhertenc concept, left for refactoring.
//                ProjectionList projectionList = Projections.projectionList();
//                projectionList.add(Projections.groupProperty(fieldNameList.get(0)));
//                projectionList.add(Projections.groupProperty(fieldNameList.get(1)));
//                projectionList.add(Projections.groupProperty(fieldNameList.get(2)));
//                criteria.setProjection(projectionList);
                
                Criteria criteria = session.createCriteria(contentClass.getClass());
                criteria.add(Restrictions.eq(contentIDname, contentID));
                
                getContentData = criteria.list();
              } 
            catch (Exception e)
              {
                System.out.println("+++++++++++++++++++++++++++++ Start : Error getting content data ++++++++++++++++++++++++++++++++++++++++");
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ End : Error getting content data ++++++++++++++++++++++++++++++++++++++++");
              } 
            finally
              {
                session.close();
                sessionFactory.close();//may not work, have to test.
                System.out.println("++++++++++++++++++++++++++++++  end getting content data +++++++++++++++++++++++++++++++++++++++");
              }

            return getContentData;
            /**
             * This object will be converted in the dao class of content vote.
             */
        }
    
    
    @Override
    public Users dao_vote_getUser_As_ContentOwner(int userID)
        {
        
        SessionFactory sessionFactory = null;
        Session session               = null;
        List getUserVoteData = null;
//No need caz they will load the entire User, left for refactoring.
//        Users usersVotedData = (Users) applicationContext.getBean("id_Users");
        Users usersDataForVote = null;
        
        try
          {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            
            Criteria criteria = session.createCriteria(Users.class);
            
//No need caz they will load the entire User, left for refactoring.
//            ProjectionList projectionList = Projections.projectionList();
//            projectionList.add(Projections.groupProperty("userID"));
//            projectionList.add(Projections.groupProperty("totalUpVote"));
//            projectionList.add(Projections.groupProperty("totalDownVote"));
//            projectionList.add(Projections.groupProperty("profileWeight"));
            
            criteria.add(Restrictions.eq("userID", userID));
            getUserVoteData = criteria.list();
            
            if(getUserVoteData.isEmpty() == false)
              {
                usersDataForVote  = (Users) getUserVoteData.get(0);
              }
            
//No need caz they will load the entire User, left for refactoring.            
//            Object[] object = null;
//            
//            //Just for oversure, otherwise not needed.
//            if( getUserVoteData.isEmpty() == false )
//              {
//                object = (Object[]) getUserVoteData.get(0);
//            
//                // have to check, is it efficiant or not. does it increase heap cost.
//                usersVotedData.setUserID( Integer.parseInt(object[0].toString()) ); 
//                usersVotedData.setTotalUpVote(   Float.parseFloat(object[1].toString())  ) ;
//                usersVotedData.setTotalDownVote( Float.parseFloat(object[2].toString())  ) ;
//                usersVotedData.setProfileWeight( Float.parseFloat(object[3].toString())  ) ;       
//              }
//             

          } 
        catch (Exception e)
          {
            System.out.println("+++++++++++++++++++++++++++++ Start : Error getting user vote data ++++++++++++++++++++++++++++++++++++++++");
            e.printStackTrace();
            System.out.println();
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++ End : Error getting user vote data ++++++++++++++++++++++++++++++++++++++++");
          } 
        finally
          {
            session.close();
//            sessionFactory.close();//may not work, have to test.
            System.out.println("++++++++++++++++++++++++++++++  End : getting user vote data +++++++++++++++++++++++++++++++++++++++");
          }
        
        return usersDataForVote;
        }
    
    
    /**
     *
     * Object userVote = the vote that given, Object userProfileWithVoteData =
     * to update the user profile with new vote data., Object contentVoteData =
     * content data to update the content votes information, String
     * voteOperationName = two values possible, save= new vote, update= have to
     * update existing vote.
     *
     */
    @Override
    public String custUserVoteData(Object userVote, Object userProfileWithVoteData, Object contentVoteData, String voteOperationName)
        {
        
            /**
             * 
             * Object userVote = the vote that given, 
             * Object userProfileWithVoteData = to update the user profile with new vote data., 
             * Object contentVoteData = content data to update the content votes information, 
             * String voteOperationName = two values possible, save= new vote, update= have to update existing vote.
             * 
             */
        
            String voteCustMessage = "";
            SessionFactory sessionFactory = null;
            Session session = null;
            
            try
              {
                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();

                Transaction tx = session.beginTransaction();
                
                if(voteOperationName.equals("save"))
                  {
                      System.out.println("\n if(voteOperationName.equals(\"save\")) \n");
                    session.save(userVote);
                  }
                if(voteOperationName.equals("update"))
                  {
                    session.update(userVote);
                  }
                System.out.println("\n problem is here...start : session.merge(userProfileWithVoteData);\n");
                session.merge(userProfileWithVoteData);
                System.out.println("\n problem is here...end : session.merge(userProfileWithVoteData);\n");
                
                System.out.println("\n problem is here...start : session.update(contentVoteData);\n");
                session.update(contentVoteData);
                System.out.println("\n problem is here...end : session.update(contentVoteData);\n");
                
                System.out.println("\n problem is here...start : tx.commit(); \n");
                tx.commit();
                System.out.println("\n problem is here...end : tx.commit(); \n");
                
                voteCustMessage = "voteCustSuccess";
              } 
            catch (Exception e)
              {
                voteCustMessage = "voteCustFail";
                System.out.println("+++++++++++++++++++++++++++++ Start : error in vote cust ++++++++++++++++++++++++++++++++++++++++");
                System.out.println();
                e.printStackTrace();
                System.out.println();
                System.out.println();
                System.out.println("+++++++++++++++++++++++++++++ End : error in vote cust ++++++++++++++++++++++++++++++++++++++++");
              } 
            finally
              {
                session.close();
                sessionFactory.close();
                System.out.println("++++++++++++++++++++++++++++++  End vote cust  +++++++++++++++++++++++++++++++++++++++");
              }
            return voteCustMessage;
        }
    }
