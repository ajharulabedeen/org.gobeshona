/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobeshonabd.messages;

import java.util.List;

/**
 *
 * @author Dell-3460
 */
public class Services_Message_Exception_Impl implements Services_Message_Exception_I
    {

//    Bean Start : ************************************************************************
    private DAO_Message_Exception_I bean_dao_Message_Exception_I;
    public DAO_Message_Exception_I getBean_dao_Message_Exception_I()
        {
        return bean_dao_Message_Exception_I;
        }

    public void setBean_dao_Message_Exception_I(DAO_Message_Exception_I bean_dao_Message_Exception_I)
        {
        this.bean_dao_Message_Exception_I = bean_dao_Message_Exception_I;
        }
//    Bean end : ************************************************************************    
        
    
        @Override
        public String services_add_to_exception_list(int user_who_will_make_exception, int user_who_will_be_made_exception)
            {
                return bean_dao_Message_Exception_I.dao_add_to_exception_list(user_who_will_make_exception, user_who_will_be_made_exception);
            }
        @Override
        public String services_remove_from__exception_list(int user_who_will_make_unexception, int user_who_will_be_made_unexception)
            {
                return bean_dao_Message_Exception_I.dao_remove_from__exception_list(user_who_will_make_unexception, user_who_will_be_made_unexception);
            }
        @Override
        public List services_see_who_you_made_exception(int userID_see_who_you_made_exception)
            {
                return bean_dao_Message_Exception_I.dao_see_who_you_made_exception(userID_see_who_you_made_exception);
            }
        @Override
        public List services_see_who_made_you_exception(int userID_see_who_made_you_exception)
            {
                return bean_dao_Message_Exception_I.dao_see_who_made_you_exception(userID_see_who_made_you_exception);
            }
    }
