package com.zhang.pm.mapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.zhang.pm.beans.Employee;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.pm.mapper
 * @date:2020/12/29
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    List<Employee> getAll(@Param(Constants.WRAPPER) Wrapper ew);

}
