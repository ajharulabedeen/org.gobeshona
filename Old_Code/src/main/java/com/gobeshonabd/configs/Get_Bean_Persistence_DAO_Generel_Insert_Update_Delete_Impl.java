package com.gobeshonabd.configs;

import com.gobeshonabd.persistence.DAO_Generel_Insert_Update_Delete_SelectAll_I;

public interface Get_Bean_Persistence_DAO_Generel_Insert_Update_Delete_Impl
    {

    public DAO_Generel_Insert_Update_Delete_SelectAll_I bean_generel_Insert_Update_Delete_SelectAll_I
            = (DAO_Generel_Insert_Update_Delete_SelectAll_I) SpringContextSingletron.getApplicationContext()
                    .getBean("id_DAO_Generel_Insert_Update_Delete_SelectAll_Impl");
    }
