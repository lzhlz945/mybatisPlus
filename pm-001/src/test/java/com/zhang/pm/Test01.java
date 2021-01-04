package com.zhang.pm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.pm.beans.Employee;
import com.zhang.pm.config.MybatisPlusConfig;
import com.zhang.pm.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

    private EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);


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

    @Test
    public void test33(){

        ApplicationContext context1=new AnnotationConfigApplicationContext("com.zhang.pm.config");
        MybatisPlusConfig mybatisPlusConfig = context1.getBean("mybatisPlusConfig", MybatisPlusConfig.class);
        MybatisPlusInterceptor mybatisPlusInterceptor = mybatisPlusConfig.mybatisPlusInterceptor();
        System.out.println(mybatisPlusInterceptor);

        Page<Employee> employeePage = employeeMapper.selectPage(new Page<Employee>(1, 4), new QueryWrapper<>());
        System.out.println(employeePage.getRecords());
        int delete = employeeMapper.delete(new QueryWrapper<>());
        System.out.println(delete);

    }
}
