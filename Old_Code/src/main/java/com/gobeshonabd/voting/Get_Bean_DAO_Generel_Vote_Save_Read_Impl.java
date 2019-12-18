package com.gobeshonabd.voting;

import com.gobeshonabd.configs.SpringContextSingletron;
import com.gobeshonabd.persistence.DAO_Generel_Insert_Update_Delete_SelectAll_I;

public interface Get_Bean_DAO_Generel_Vote_Save_Read_Impl
    {

    public DAO_Generel_Vote_Save_Read_I bean_DAO_Generel_Vote_Save_Read_I
            = (DAO_Generel_Vote_Save_Read_I) SpringContextSingletron.getApplicationContext()
                    .getBean("id_DAO_Generel_Vote_Save_Read_I");
    }
