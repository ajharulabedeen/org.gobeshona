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
public interface DAO_Message_Exception_I
    {
        public String dao_add_to_exception_list(int user_who_will_make_exception, int user_who_will_be_made_exception);
        public String dao_remove_from__exception_list(int user_who_will_make_unexception, int user_who_will_be_made_unexception);
        public List dao_see_who_you_made_exception(int userID_see_who_you_made_exception);
        public List dao_see_who_made_you_exception(int userID_see_who_made_you_exception);
    }
