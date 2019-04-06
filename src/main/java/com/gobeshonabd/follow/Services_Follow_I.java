package com.gobeshonabd.follow;

import com.gobeshonabd.pojos.Follow;
import java.util.List;

public interface Services_Follow_I
    {
      public String services_addFollower(Follow follow);
      public String services_removeFollower(Follow follow);
      public List   services_listColumnA(int userID);
      public List   services_listColumnB(int userID);
    }
