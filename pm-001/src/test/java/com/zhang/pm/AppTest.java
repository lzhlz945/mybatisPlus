package com.zhang.pm;

import static org.junit.Assert.assertTrue;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
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
    /**
     * 测试EntityWrapper1条件构造器
     */
    @Test
    public void testEntityWrapper(){
        List<Employee> employeeList = employeeMapper.selectPage(new Page<Employee>(1, 2), new EntityWrapper<Employee>()
                .between("age", 18, 50).eq("last_name", "zhang")
                .eq("gender", 1));
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

    }
    /**
     * 测试EntityWrapper2条件构造器
     */
    @Test
    public void testEntityWrapper1(){
        Employee employee=new Employee();
        employee.setAge(18);
        employee.setEmail("zs@qq.com");
        employee.setGender(1);
        employee.setLastName("zhang");
        //employeeMapper.insert(employee);
        //Integer id = employee.getId();
        List<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        List<Employee> selectList = employeeMapper.selectList(new EntityWrapper<Employee>().eq("last_name", "zhang"));
        for (Employee employee1 : selectList) {
            System.out.println(employee1);
        }

    }
    /**
     * 测试EntityWrapper条件构造器
     * 测试or()和 orNew()
     */
    @Test
    public void testEntityWrapperAndOr(){

        List<Employee> selectList = employeeMapper.selectList(new EntityWrapper<Employee>().eq("last_name", "zhang")
                                                                .like("email","l")
                                                                //.or()  //(last_name = ? AND email LIKE ? OR email LIKE ?)
                                                                .orNew() //(last_name = ? AND email LIKE ?) OR (email LIKE ?)
                                                                .like("email","z"));
        for (Employee employee1 : selectList) {
            System.out.println(employee1);
        }

    }

}
