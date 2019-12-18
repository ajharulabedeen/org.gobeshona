package com.gobeshonabd.follow;

import com.gobeshonabd.configs.DateUtil;
import com.gobeshonabd.pojos.Follow;
import java.util.List;

public class Services_Follow_Impl implements Services_Follow_I
    {

   
//    Start.... ************************ Bean Area ************************ 
    private DAO_Follow_I dao_Follow_I;
    public DAO_Follow_I getDao_Follow_I()
        {
        return dao_Follow_I;
        }
    public void setDao_Follow_I(DAO_Follow_I dao_Follow_I)
        {
        this.dao_Follow_I = dao_Follow_I;
        }
//    DateUtil bean_dateUtil = (DateUtil) applicationContext.getBean("id_date");
//    End .... ************************ Bean Area ************************ 
    
    public Services_Follow_Impl()
        {
        }

    @Override
    public String services_addFollower(Follow follow)
        {
            follow.setDate(DateUtil.getDate().toString());
            return getDao_Follow_I().dao_addFollower(follow);
        }

    @Override
    public List services_listColumnA(int userID)
        {
            return getDao_Follow_I().dao_listColumnA(userID);
        }

    @Override
    public List services_listColumnB(int userID)
        {
            return getDao_Follow_I().dao_listColumnB(userID);
        }

    @Override
    public String services_removeFollower(Follow follow)
        {
            return getDao_Follow_I().dao_removeFollower(follow);
        }
        
    }
