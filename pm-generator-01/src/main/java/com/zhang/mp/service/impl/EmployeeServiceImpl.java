package com.zhang.mp.service.impl;

import com.zhang.mp.beans.Employee;
import com.zhang.mp.mapper.EmployeeMapper;
import com.zhang.mp.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
