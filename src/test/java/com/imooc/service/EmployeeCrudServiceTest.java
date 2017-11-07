package com.imooc.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeCrudServiceTest {

    private ApplicationContext ctx = null;

    private EmployeeCrudService employeeCrudService = null;

    @Before
    public void setUp(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeCrudService = ctx.getBean(EmployeeCrudService.class);
        System.out.println("setUp!!!");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown!!!");
    }

    @Test
    public void save(){
        employeeCrudService.save();
    }
}
