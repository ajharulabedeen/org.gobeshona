package com.gobeshonabd.configs;

import com.gobeshonabd.pojos.StatusRequest;

public class StatusRequestSingleton
    {
        private static StatusRequest statusRequest_obj;
        
        public static StatusRequest getStatusRequest()
            {
                if(statusRequest_obj == null)
                  {
                    statusRequest_obj = new StatusRequest();
                  }
                return statusRequest_obj;
            }
    }
