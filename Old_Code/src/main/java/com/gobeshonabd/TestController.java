package com.gobeshonabd;

import com.gobeshonabd.configs.HibernateUtil;
import com.gobeshonabd.pojos.Follow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
    {

    @RequestMapping("/test")
    public String test()
        {
        return "@RequestMapping(\"/test\")...........Welcome to GobeshonaBD.....Alhumdulilah...The Prograsm is working....";
        }

    @RequestMapping("/testLeftJoin/{userID}")
    public List testLeftJoin( @PathVariable int userID)
        {
           SessionFactory sessionFactory = null;
              Session session = null;

              sessionFactory = HibernateUtil.getSessionFactory();
              session = sessionFactory.openSession();
              String queryNativeMysql_availList_block_exception = ""
                      + "  SELECT"
                      + "      users.user_id,          " //0
                      + "      users.user_first_name,  " //1
                      + "      users.user_last_name,   " //2
                      + "      users.total_up_vote,    " //3
                      + "      users.total_down_vote   " //4
                      + "  FROM"
                      + "      users "
                      + "  INNER JOIN "
                      + "      messages"
                      + "      ON users.user_id = messages.message_receiver_id "
                      + "  WHERE users.user_id  "
                      + "      NOT IN  ( SELECT "
                      + "            	message_block.user_who_will_be_blocked "
                      + "              FROM "
                      + "            	message_block "
                      + "              WHERE "
                      + "            	message_block.user_who_will_block = " + userID
                      + "              )"
                      + "  AND users.user_id "
                      + "     NOT IN  ( SELECT "
                      + "            	message_exception.user_who_will_be_made_exception "
                      + "              FROM "
                      + "            	message_exception "
                      + "              WHERE "
                      + "            	message_exception.user_who_will_make_exception = " + userID
                      + "              )"
                      + "  AND"
                      + "      messages.message_receiver_id= " + userID
                      + "  AND"
                      + "    messages.read_status =1 ";

              List availableuser_List_for_block_exception = new ArrayList();

              List nativeList = session.createSQLQuery(queryNativeMysql_availList_block_exception).list();

              Iterator iterator = nativeList.iterator();
              while (iterator.hasNext())
                {
                  Object[] next = (Object[]) iterator.next();
                  Map map_availUser_block_exception = new HashMap();
                  map_availUser_block_exception.put("user_id", next[0]);
                  map_availUser_block_exception.put("user_last_name", next[1]);
                  map_availUser_block_exception.put("total_up_vote", next[2]);
                  map_availUser_block_exception.put("total_down_vote", next[3]);
                  availableuser_List_for_block_exception.add(map_availUser_block_exception);
                }//while (iterator.hasNext())

              session.close();
              sessionFactory.close();
              
              return availableuser_List_for_block_exception;
//            return nativeList;
        }
    }
