package com.gobeshonabd.messages;

import com.gobeshonabd.configs.MapSingleton;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller_MessagesBlocking 
    {
        @Autowired
        private Services_MessageBlocking_I bean_services_MessagesBlocking_I ;
        
        Map map = MapSingleton.getMap();
        
        @RequestMapping( value = "/add_To_Block_List", method = RequestMethod.POST)
        public Map add_To_Block_List(@RequestParam int userID_who_will_block, @RequestParam int userID_who_will_be_blocked  )
          {
            map.clear();
            map.put("status", bean_services_MessagesBlocking_I.services_add_To_Block_List(userID_who_will_block, userID_who_will_be_blocked));
            return map;
          }
        
        @RequestMapping( value = "/remove_From_Block_List", method = RequestMethod.DELETE)
        public Map remove_From_Block_List(@RequestParam int userID_who_will_unblock,@RequestParam int userID_who_will_be_unblocked  )
          {
            map.clear();
            map.put("status", bean_services_MessagesBlocking_I.services_remove_From_Block_List(userID_who_will_unblock, userID_who_will_be_unblocked) );
            return map;
          }
        
        @RequestMapping( value = "/see_Who_You_Blocked_list/{userID_see_ur_block_list}", method = RequestMethod.GET)
        public List see_Who_You_Blocked_list(@PathVariable int userID_see_ur_block_list)
          {
           return bean_services_MessagesBlocking_I.services_see_Who_You_Blocked_list(userID_see_ur_block_list);
          }
        
        @RequestMapping( value = "/see_Who_Blocked_You/{userID_see_who_blocked_u_list}", method = RequestMethod.GET)
        public List see_Who_Blocked_You(@PathVariable int userID_see_who_blocked_u_list)
          {
           return bean_services_MessagesBlocking_I.services_see_Who_Blocked_You(userID_see_who_blocked_u_list);
          }

    }
