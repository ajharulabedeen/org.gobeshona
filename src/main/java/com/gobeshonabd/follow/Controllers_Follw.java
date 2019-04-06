package com.gobeshonabd.follow;

import com.gobeshonabd.pojos.Follow;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers_Follw 
    {
        @Autowired
        Services_Follow_I services_Follow_I ;
        
        @RequestMapping(value = "/addFollower", method = RequestMethod.POST)
        public Map services_addFollower(@RequestBody Follow follow)
            {
                Map requestStatus_map = new HashMap();
                requestStatus_map.put("addFollower", services_Follow_I.services_addFollower(follow));
                return requestStatus_map;
            }
        
        @RequestMapping(value = "/removeFollower", method = RequestMethod.DELETE)
        public Map services_removeFollower(Follow follow)
            {
                Map requestStatus_map = new HashMap();
                requestStatus_map.put("deleteFollower", services_Follow_I.services_removeFollower(follow));
                return requestStatus_map;
            }
        
        @RequestMapping(value = "/listColumnA/{userID}", method = RequestMethod.GET)
        public List services_list_i_am_following(@PathVariable int userID)
            {
                return services_Follow_I.services_listColumnA(userID);
            }
        
        @RequestMapping(value = "/listColumnB/{userID}", method = RequestMethod.GET)
        public List services_list_who_follow_me(@PathVariable int userID)
            {
                return services_Follow_I.services_listColumnB(userID);
            }
    }
