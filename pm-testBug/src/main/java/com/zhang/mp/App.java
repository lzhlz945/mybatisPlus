package com.zhang.mp;

import com.zhang.mp.beans.Employee;
import org.junit.Test;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    @Test
    public void test01(){
        Employee employee = new Employee();
        List<Employee> employees = employee.selectAll();
        System.out.println(employees);




    }
}
