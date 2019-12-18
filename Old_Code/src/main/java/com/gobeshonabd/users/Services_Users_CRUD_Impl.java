package com.gobeshonabd.users;

import com.gobeshonabd.configs.GetDate;
import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.configs.SpringApplicationContextInterface;
import com.gobeshonabd.pojos.Users;
import java.util.List;
import com.gobeshonabd.persistence.DAO_Generel_Insert_Update_Delete_SelectAll_I;
import com.gobeshonabd.pojos.User_Roles;
import com.gobeshonabd.pojos.Users_Public_View;
import com.gobeshonabd.pojos.Users_Security;
import com.gobeshonabd.services.Services_User_PasswordEncryption_I;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Services_Users_CRUD_Impl implements Services_Users_CRUD_I, SpringApplicationContextInterface

    {

//Start Bean area -----------------------------------------------------------------------------------------
//************************************ Injection *************************************    
    private DAO_Users_CRUD_I dao_users_CRUD_I;

    public DAO_Users_CRUD_I getDao_users_CRUD_I()
        {
        return dao_users_CRUD_I;
        }

    public void setDao_users_CRUD_I(DAO_Users_CRUD_I dao_users_CRUD_I)
        {
        this.dao_users_CRUD_I = dao_users_CRUD_I;
        }

//    *****************
    private DAO_Generel_Insert_Update_Delete_SelectAll_I selectAll_I;

    public DAO_Generel_Insert_Update_Delete_SelectAll_I getSelectAll_I()
        {
        return selectAll_I;
        }

    public void setSelectAll_I(DAO_Generel_Insert_Update_Delete_SelectAll_I selectAll_I)
        {
        this.selectAll_I = selectAll_I;
        }

//*********************************************************
//    private Services_User_PasswordEncryption_I services_User_PasswordEncryption_I;
//
//    public Services_User_PasswordEncryption_I getServices_User_PasswordEncryption_I()
//        {
//        return services_User_PasswordEncryption_I;
//        }
//
//    public void setServices_User_PasswordEncryption_I(Services_User_PasswordEncryption_I services_User_PasswordEncryption_I)
//        {
//        this.services_User_PasswordEncryption_I = services_User_PasswordEncryption_I;
//        }
//************************************ Injection *************************************    
//    
//    
//    private DAO_Generel_Insert_Update_Delete_SelectAll_I selectAll_I
//            = (DAO_Generel_Insert_Update_Delete_SelectAll_I) 
//            applicationContext.getBean("id_Persistence_DAO_Generel_Insert_Update_Delete_Impl");

//End Bean area -----------------------------------------------------------------------------------------
    public Services_Users_CRUD_Impl()
        {

        }

//************* Start. These method from --- Persistence_DAO_Generel_Insert_Update_Delete_Impl ********************
    @Override
    public String services_insertUser(Users usersBeanToInsert)
        {
        
        String insertMessage = "Sorry this mail ID already Registered";

        if (userNameAvailableCheck(usersBeanToInsert.getEmailID()).equals("success"))
            {
//            usersBeanToInsert.setPassword(new BCryptPasswordEncoder().encode(usersBeanToInsert.getPassword()));
            usersBeanToInsert.setJoinDate(GetDate.getDate());
            
            Users_Security  users_Security_to_insert    = new Users_Security(usersBeanToInsert.getEmailID(), usersBeanToInsert.getPassword(), 1);
            User_Roles      user_Roles_to_insert        = new User_Roles( usersBeanToInsert.getEmailID(), "ADMIN");
            
            insertMessage = getDao_users_CRUD_I().dao_insertUser(usersBeanToInsert,users_Security_to_insert,user_Roles_to_insert);
            }
//        insertMessage = getDao_users_CRUD_I().dao_insertUser(usersBeanToInsert);

        return insertMessage;
        }

    @Override
    public String services_updateUser(Users usersBeanToUpdate)
        {
        /**
         * Here this below line will return "successUpdate" string, if update
         * done successfully, else return "failUpdate" string, if any failure
         * occurs to update.
         */
        //This object has not used.
        User_Roles user_Roles_to_update = new User_Roles( usersBeanToUpdate.getEmailID(), "ADMIN");
        return getDao_users_CRUD_I().dao_updateUser(usersBeanToUpdate, user_Roles_to_update);
        }

    @Override
    public String services_deleteUser(Users usersBeanToDelete)
        {
        /**
         * Here this below line will return "successDelete" string, if Delete
         * done successfully, else return "failDelete" string, if any failure
         * occurs to Delete.
         */
        return getDao_users_CRUD_I().dao_deleteUser(usersBeanToDelete);
        }
//*************End. These method from -- Persistence_DAO_Generel_Insert_Update_Delete_Impl ********************

    @Override
    public List<Users_Public_View> services_getAllUsersDataToShowPublic()
        {
        return getDao_users_CRUD_I().dao_getAllUsersDataToShowPublic();
        }

    @Override
    public List<Users> services_getSpecificUserData(int userID)
        {
        System.out.println("\n public List<Users> services_getSpecificUserData(int userID) \n");
        return getDao_users_CRUD_I().dao_getSpecificUserData(userID);
        }

//    Start : TO do first Separation of Concern theory not applied.
    public String userNameAvailableCheck(String emailID)
        {
        String availableMessage = "fail";
    
        SessionFactory sessionFactory = null;
        Session session = null;
        List getUserData_list = null;

        try
          {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(Users.class);
            Criterion search = Restrictions.eq("emailID", emailID);
            criteria.add(search);
            getUserData_list = criteria.list();
            
            if(getUserData_list.isEmpty())
              {
                availableMessage = "success";
              }
          }
        catch (Exception e)
          {
            e.printStackTrace();
            System.out.println();
            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++ Error getting User name available check ++++++++++++++++++++++++++++++++++++++++");
          } 
        finally
          {
            session.close();
            sessionFactory.close();
            System.out.println("++++++++++++++++++++++++++++++  end User name available check +++++++++++++++++++++++++++++++++++++++");
          }

        return availableMessage;
        }
    
//    End : TO do first Separation of Concern theory not applied.
    
    }
