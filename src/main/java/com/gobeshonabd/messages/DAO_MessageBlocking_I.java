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
public interface DAO_MessageBlocking_I
    {
        public String dao_add_To_Block_List(int userID_who_will_block, int userID_who_will_be_blocked );
        public String dao_remove_From_Block_List(int userID_who_will_unblock, int userID_who_will_be_unblocked);
        public List dao_see_Who_You_Blocked_list(int userID_see_ur_block_list);
        public List dao_see_Who_Blocked_You(int userID_see_who_blocked_u_list);
    }
