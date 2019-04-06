package com.gobeshonabd.users;

import com.gobeshonabd.pojos.Users;
import com.gobeshonabd.pojos.Users_Public_View;
import java.util.List;

public interface Services_Users_CRUD_I
    {
        public String services_insertUser(Users usersBeanToInsert);
        public String services_updateUser(Users usersBeanToUpdate);
        public String services_deleteUser(Users usersBeanToDelete);
        public List<Users_Public_View> services_getAllUsersDataToShowPublic();
        public List<Users> services_getSpecificUserData(int userID);
    }
