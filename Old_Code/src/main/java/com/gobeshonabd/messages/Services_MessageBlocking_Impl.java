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
public class Services_MessageBlocking_Impl implements Services_MessageBlocking_I
    {
//bean : ****************************************************************************
    private DAO_MessageBlocking_I bean_dao_MessageBlocking_I;
    
    public DAO_MessageBlocking_I getBean_dao_MessageBlocking_I()
        {
        return bean_dao_MessageBlocking_I;
        }
    public void setBean_dao_MessageBlocking_I(DAO_MessageBlocking_I bean_dao_MessageBlocking_I)
        {
        this.bean_dao_MessageBlocking_I = bean_dao_MessageBlocking_I;
        }
//bean : ****************************************************************************        
    
        public String services_add_To_Block_List(int userID_who_will_block, int userID_who_will_be_blocked )
            {
                return bean_dao_MessageBlocking_I.dao_add_To_Block_List(userID_who_will_block, userID_who_will_be_blocked);
            }
        public String services_remove_From_Block_List(int userID_who_will_unblock, int userID_who_will_be_unblocked)
            {
                return bean_dao_MessageBlocking_I.dao_remove_From_Block_List(userID_who_will_unblock, userID_who_will_be_unblocked);
            }
        public List services_see_Who_You_Blocked_list(int userID_see_ur_block_list)
            {
                return bean_dao_MessageBlocking_I.dao_see_Who_You_Blocked_list(userID_see_ur_block_list);
            }
        public List services_see_Who_Blocked_You(int userID_see_who_blocked_u_list)
            {
                return bean_dao_MessageBlocking_I.dao_see_Who_Blocked_You(userID_see_who_blocked_u_list);
            }
    }
