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
public class Controller_MessagesException 
    {
        @Autowired
        private Services_Message_Exception_I bean_services_MessagesException_I ;
        
        Map map = MapSingleton.getMap();
        
        @RequestMapping( value = "/add_to_exception_list", method = RequestMethod.POST)
        public Map add_to_exception_list(@RequestParam int user_who_will_make_exception, @RequestParam int user_who_will_be_made_exception  )
          {
            map.clear();
            map.put("status", bean_services_MessagesException_I.services_add_to_exception_list(user_who_will_make_exception, user_who_will_be_made_exception) );
            return map;
          }
        
        @RequestMapping( value = "/remove_from__exception_list", method = RequestMethod.DELETE)
        public Map remove_from__exception_list(@RequestParam int user_who_will_make_unexception,@RequestParam int user_who_will_be_made_unexception  )
          {
            map.clear();
            map.put("status", bean_services_MessagesException_I.services_remove_from__exception_list(user_who_will_make_unexception, user_who_will_be_made_unexception) );
            return map;
          }
        
        @RequestMapping( value = "/see_who_you_made_exception/{userID_see_who_you_made_exception}", method = RequestMethod.GET)
        public List see_who_you_made_exception( @PathVariable int userID_see_who_you_made_exception)
          {
           return bean_services_MessagesException_I.services_see_who_you_made_exception(userID_see_who_you_made_exception);
          }
        
        @RequestMapping( value = "/see_who_made_you_exception/{userID_see_who_made_you_exception}", method = RequestMethod.GET)
        public List see_who_made_you_exception( @PathVariable int userID_see_who_made_you_exception)
          {
           return bean_services_MessagesException_I.services_see_who_made_you_exception(userID_see_who_made_you_exception);
          }

    }
