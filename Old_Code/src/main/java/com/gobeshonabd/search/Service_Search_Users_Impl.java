/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gobeshonabd.search;

import java.util.List;

/**
 *
 * @author Dell-3460
 */
public class Service_Search_Users_Impl implements Service_Search_Users_I
    {

//    Start Bean : **********************************************
    private DAO_Search_Users_I bean_dao_Search_Users_I;
    public DAO_Search_Users_I getBean_dao_Search_Users_I()
        {
            return bean_dao_Search_Users_I;
        }
    public void setBean_dao_Search_Users_I(DAO_Search_Users_I bean_dao_Search_Users_I)
        {
            this.bean_dao_Search_Users_I = bean_dao_Search_Users_I;
        }
//    End Bean : **********************************************        
        
        @Override
        public List service_search_users (String searchStringUser, String columnNameUser)
            {
                return bean_dao_Search_Users_I.dao_search_users(searchStringUser, columnNameUser);
            }    
    }
