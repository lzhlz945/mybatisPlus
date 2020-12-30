package com.zhang.pm;

import com.zhang.pm.beans.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.pm
 * @date:2020/12/30
 */
public class Test01 {

    private ApplicationContext context=new ClassPathXmlApplicationContext("spring/applicationContext.xml");


    @Test
    public void test001(){

        Employee employee=new Employee();
        employee.setAge(18);
        employee.setEmail("zs@qq.com");
        employee.setGender(1);
        employee.setLastName("zhang");
        boolean insert = employee.insert();
        System.out.println(insert);

    }
}
