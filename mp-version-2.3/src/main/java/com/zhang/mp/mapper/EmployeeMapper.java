package com.zhang.mp.mapper;

import com.zhang.mp.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhl
 * @since 2021-01-04
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    int deleteAll();
}
