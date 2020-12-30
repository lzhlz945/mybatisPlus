package com.zhang.mp.service;

import com.zhang.mp.beans.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhl
 * @since 2020-12-30
 */
public interface EmployeeService extends IService<Employee> {

    List<Employee> getEmps();
}
