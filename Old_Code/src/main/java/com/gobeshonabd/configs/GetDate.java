package com.gobeshonabd.configs;

import static com.gobeshonabd.configs.SpringContextSingletron.applicationContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetDate
    {

    public static String getDate()
        {
            SimpleDateFormat dateFormat = SimpleDateFormatUtil.getSimpleDateFormat();
            Date date = DateUtil.getDate();
            return dateFormat.format(date);
        }
    }
