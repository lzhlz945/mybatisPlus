package com.zhang.mp.service.impl;

import com.zhang.mp.beans.Employee;
import com.zhang.mp.mapper.EmployeeMapper;
import com.zhang.mp.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhl
 * @since 2020-12-31
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> selectAll1() {
        ArrayList<Integer> employees = new ArrayList<>();
        employees.add(5);
        employees.add(6);
        employees.add(7);
        Employee employee = new Employee();
        List<Employee> employees1 = employee.selectAll();
        return employees1;
    }
}
