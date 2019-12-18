package com.gobeshonabd.testingpurpose;

import com.gobeshonabd.configs.SpringApplicationContextInterface;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller_test 
    {

    @RequestMapping(value = "/testt", method = RequestMethod.POST)
    public void testt(@RequestBody Test t)
        {
            System.out.println("X : "+t.getX());
            System.out.println("Y : "+t.getY());
        }

    }
