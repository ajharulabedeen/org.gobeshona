package com.gobeshonabd.persistence;

/**
 * Here 3 methods actually doing same thing, except the
 * session.delete(objectToDelete); session.merge(objectToUpdate);
 * session.save(objectToInsert); these method can be written in one method, by
 * their operation can be controlled by if..else by taking a operation name as
 * param with the pojo bean.
 *
 * but to maintain the separate of concern it is not done. becaz if in future if
 * we required to do any change of these operations then have to think about
 * other operations.
 *
 * so if these operations kept separate then it will be easy to maintain.
 *
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.gobeshonabd.configs.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import com.gobeshonabd.pojos.Articles;

public class DAO_Generel_Insert_Update_Delete_SelectAll_Impl
        implements
        DAO_Generel_Insert_Update_Delete_SelectAll_I
    {

    public DAO_Generel_Insert_Update_Delete_SelectAll_Impl()
        {

        }

    @Override
    /**
     * Here this below line will return "successInsert" string, if insertion
     * done successfully, else return "failInsert" string, if any failure occurs
     * to insert.
     */
    public String dao_Generel_Insert(Object objectToInsert)
        {
        String dataInsertionStatus = " public String dao_Generel_Insert(Object objectToInsert) ";

        SessionFactory sessionFactory = null;
        Session session = null;

        try
          {
            sessionFactory = HibernateUtil.getSessionFactory();

            session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            session.save(objectToInsert);
              System.out.println("\n\n"+objectToInsert.getClass());
              tx.commit();
            
            dataInsertionStatus = "successInsert";
          } 
        catch (Exception e)
          {
            dataInsertionStatus = "failInsert";
            System.out.println("\n\nGenerel Insertion Error : " + e.getClass());
            System.out.println("Error occured in  : " + DAO_Generel_Insert_Update_Delete_SelectAll_Impl.class);
            System.out.println();
            e.printStackTrace();
            System.out.println();
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++ Insert error ++++++++++++++++++++++++++++++++++++++++");
          } 
        finally
          {
            session.close();
            sessionFactory.close();
            System.out.println("++++++++++++++++++++++++++++++  Insert +++++++++++++++++++++++++++++++++++++++");
          }

        return dataInsertionStatus;
        }

    @Override
    /**
     * Here this below line will return "successDelete" string, if Delete done
     * successfully, else return "failDelete" string, if any failure occurs to
     * Delete.
     */
    public String dao_Generel_Delete(Object objectToDelete)
        {
        String dataDeleteStatus = "public String dao_Generel_Delete(Object objectToDelete)";
        
        
//***************** Test Code **************************************************
//            Users u = (Users) objectToDelete;        
//        System.out.println(" \n UserID: " + u.getUserID());
//***************** Test Code **************************************************
        
        
            System.out.println("\n...Delete...\n");
        
        SessionFactory factory = null;
        Session session = null;

        try
          {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();
            Transaction tx = session.beginTransaction();

            session.delete(objectToDelete);

            tx.commit();
            dataDeleteStatus = "successDelete";
          } 
        catch (Exception e)
          {
            dataDeleteStatus = "failDelete";
            System.out.println("\n\nGenerel Deletion Error : " + e.getClass());
            System.out.println("Error occured in  : " + DAO_Generel_Insert_Update_Delete_SelectAll_Impl.class);
            e.printStackTrace();
            System.out.println();
            System.out.println();
          } 
        finally
          {
            session.close();
            factory.close();
            System.out.println("++++++++++++++++++++++++++++++  Delete +++++++++++++++++++++++++++++++++++++++");
          }

        return dataDeleteStatus;
        }

    @Override
    /**
     * Here this below line will return "successUpdate" string, if update done
     * successfully, else return "failUpdate" string, if any failure occurs to
     * update.
     */
    public String dao_Generel_Update(Object objectToUpdate)
        {
        String dataUpdateStatus;

        SessionFactory factory = null;
        Session session = null;

        try
          {
            factory = HibernateUtil.getSessionFactory();
            session = factory.openSession();

            Transaction tx = session.beginTransaction();

              System.out.println("\n \n");
                    
            
//            session.update(objectToUpdate);
            session.update(objectToUpdate);

            tx.commit();

            dataUpdateStatus = "successUpdate";
          } 
        catch (Exception e)
          {
            dataUpdateStatus = "failUpdate";
            System.out.println("\n\nGenerel Update Error : " + e.getClass());
            System.out.println("Error Occured in  : " + DAO_Generel_Insert_Update_Delete_SelectAll_Impl.class);
            e.printStackTrace();
            System.out.println();
            System.out.println();
          } 
        finally
          {
            session.close();
            factory.close();
          System.out.println("\n+++++++++++++++++++++++++ Update Done +++++++++++++++++++++++++ \n");
          }

        return dataUpdateStatus;
        }
        
    @Override
    public List dao_Generel_SelectAll(String query)
        {
        
        SessionFactory sessionFactory = null;
        Session session = null;
        Query qry;
        List listOfAllDataAsQury = null;

        try
          {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            qry = session.createQuery(query);
            listOfAllDataAsQury = qry.list();
          } 
        catch (Exception e)
          {
            System.out.println("\n Error in Reading a list of Data. \n");
            System.out.println("Requested Query is : " + query);
            e.printStackTrace();
            System.out.println("\n\n");
          } 
        finally
          {
            qry = null;
            session.close();
            sessionFactory.close();//this might  not be worked, have to check, coz other places not worked.
            System.out.println("++++++++++++++++++++++++++++++  Select all on sent qury +++++++++++++++++++++++++++++++++++++++");
          }
        return listOfAllDataAsQury;
        }
    }
