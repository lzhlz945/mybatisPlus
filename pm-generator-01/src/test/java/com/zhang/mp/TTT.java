package com.zhang.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.mp.beans.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.mp
 * @date:2020/12/31
 */
public class TTT {
    private ApplicationContext context=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    @Test
    public void tt(){
        Employee employee = new Employee();
        employee.setId(6);
        Employee employee1 = employee.selectById();

        System.out.println(employee1);
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
}
