package com.zhang.mp.service.impl;

import com.zhang.mp.beans.Employee;
import com.zhang.mp.mapper.EmployeeMapper;
import com.zhang.mp.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhl
 * @since 2020-12-30
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Override
    public List<Employee> getEmps() {
        return null;
    }
}
