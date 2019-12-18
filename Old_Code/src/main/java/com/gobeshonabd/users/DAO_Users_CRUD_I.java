package com.gobeshonabd.users;

import com.gobeshonabd.pojos.User_Roles;
import com.gobeshonabd.pojos.Users;
import com.gobeshonabd.pojos.Users_Public_View;
import com.gobeshonabd.pojos.Users_Security;
import java.util.List;

public interface DAO_Users_CRUD_I
    {
        public String dao_insertUser(Users usersBeanToInsert,Users_Security users_Security_to_insert, User_Roles user_Role_insert);
        public String dao_updateUser(Users usersBeanToUpdate, User_Roles user_Role_update);
        public String dao_deleteUser(Users usersBeanToDelete);
        public List<Users_Public_View> dao_getAllUsersDataToShowPublic();
        public List<Users> dao_getSpecificUserData(int userID);
    }
