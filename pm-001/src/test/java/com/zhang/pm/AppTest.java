package com.zhang.pm;

import static org.junit.Assert.assertTrue;

import com.zhang.pm.beans.Employee;
import com.zhang.pm.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private ApplicationContext context=new ClassPathXmlApplicationContext("spring/applicationContext.xml");

    private EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource =  context.getBean("dataSource",DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }

    /**
     * 测试mp添加数据
     */
    @Test
    public void testInsertMp(){

        Employee employee=new Employee();
        employee.setAge(18);
        employee.setEmail("zs@qq.com");
        employee.setGender(1);
        employee.setLastName("zhang");
        //employeeMapper.insert(employee);
        //Integer id = employee.getId();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Employee> employees = employeeMapper.selectBatchIds(list);
        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }


    }
}