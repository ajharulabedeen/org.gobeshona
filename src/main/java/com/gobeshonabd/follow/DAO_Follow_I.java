package com.gobeshonabd.follow;

import com.gobeshonabd.pojos.Follow;
import java.util.List;

/**
 * 
 * To get the list who are following-------
 *      Who u are following, to get that list
 *          select from ColumnA, u will get the list of ID who u are following.
 * To get the list who following u-------
 *      Who u are following, to get that list
 *          select from ColumnB, u will get the list of ID who are following U.
 */
public interface DAO_Follow_I
    {
        String dao_addFollower(Follow follow);
        String dao_removeFollower(Follow follow);
        List dao_listColumnA(int userID);
        List dao_listColumnB(int userID);
//No Need************** Follower will be counted in the font end by NG
//        int dao_countFollower(int userID);
    }
