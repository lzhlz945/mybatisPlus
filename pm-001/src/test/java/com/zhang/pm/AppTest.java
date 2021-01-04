package com.zhang.pm;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        QueryWrapper<Employee> queryWrapper=new QueryWrapper<Employee>();

        Page<Employee> employeePage = employeeMapper.selectPage(new Page<Employee>(1, 2), queryWrapper.eq("last_name", "zhang"));
        System.out.println(employeePage);
    }
    /**
     * 测试EntityWrapper2条件构造器
     */
    @Test
    public void testEntityWrapper1(){
        QueryWrapper<Employee> queryWrapper=new QueryWrapper<Employee>();
        List<Employee> selectList = employeeMapper.selectList(queryWrapper.eq("last_name", "zhang"));
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
        QueryWrapper<Employee> queryWrapper=new QueryWrapper<Employee>();
        List<Employee> selectList = employeeMapper.selectList(queryWrapper.eq("last_name", "zhang")
                                                                .like("email","l")
                                                                //.or()  //(last_name = ? AND email LIKE ? OR email LIKE ?)
                                                                .or()//(last_name = ? AND email LIKE ?) OR (email LIKE ?)
                                                                .like("email","z"));
        for (Employee employee1 : selectList) {
            System.out.println(employee1);
        }

    }
    /**
     * 测试EntityWrapper条件构造器
     * orderBy和last()测试
     */
    @Test
    public void testEntityWrapperAndOderByAndLast(){
        QueryWrapper<Employee> queryWrapper=new QueryWrapper<Employee>();
        List<Employee> employees = employeeMapper.selectList(queryWrapper.orderBy(false,true,"age").last("limit 1,3")
                                                                );
        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }

    }

    /**
     * 测试EntityWrapper条件构造器
     * orderBy和last()测试
     */
    @Test
    public void testEntityCondition(){
        UpdateWrapper<Employee> updateWrapper=new UpdateWrapper<>();
        Employee employee=new Employee();
        employee.setAge(1222);
        employee.setEmail("zs@qq.com");
        employee.setGender(0);
        employee.setLastName("zhang");
        int employees = employeeMapper.update(employee,updateWrapper.eq("id","1"));


    }

    /**
     * 测试EntityWrapper条件构造器
     * 自定义sql使用wrapper
     */
    @Test
    public void testCustomizeSql(){
        QueryWrapper<Employee> queryWrapper=new QueryWrapper<Employee>();
        List<Employee> all = employeeMapper.getAll(queryWrapper.eq("last_name", "zhang"));
        for (Employee employee : all) {

            System.out.println(employee);
        }
    }

    /**
     * 测试EntityWrapper条件构造器
     * 自定义sql使用wrapper
     */
    @Test
    public void testCustomizeSql1(){
        QueryWrapper<Employee> queryWrapper=new QueryWrapper<Employee>();

        int id = employeeMapper.delete(queryWrapper.eq("id", 1));
    }
    
    /**
     * testPageInfo
     */
    @Test
    public void testPageInfo(){

        Page<Employee> employeePage = employeeMapper.selectPage(new Page<>(1, 1), null);
        System.out.println(employeePage.getRecords());
    }

    /**
     * testPageInfo
     */
    @Test
    public void testZXQ(){

        int delete = employeeMapper.delete(new QueryWrapper<>());
        System.out.println(delete);

    }

}
