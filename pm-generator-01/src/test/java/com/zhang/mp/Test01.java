package com.zhang.mp;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.mp.beans.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


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
        employee.setLastName("zhang");
        boolean insert = employee.insert();
        System.out.println(insert);

    }

    /**
     * Ar实现curd
     */
    @Test
    public void test002(){

        Employee employee=new Employee();

        List<Employee> employees = employee.selectList(new QueryWrapper<Employee>().like("last_name","1"));
        for (Employee employee1 : employees) {

            System.out.println(employee1);
        }

    }
    /**
     * Ar实现page
     */
    @Test
    public void test003(){

        Employee employee=new Employee();

        Page<Employee> employeePage = employee.selectPage(new Page<Employee>(1,2), new QueryWrapper<Employee>().eq("last_name", "zhang"));
        System.out.println(employeePage.getPages());
        System.out.println(employeePage.getRecords());

    }

    @Test
    public void test01(){

        Employee employee = new Employee();
        List<Employee> employees = employee.selectAll();
        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }

    }
}
