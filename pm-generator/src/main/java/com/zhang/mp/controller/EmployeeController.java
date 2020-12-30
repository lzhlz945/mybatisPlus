package com.zhang.mp.controller;


import com.zhang.mp.beans.Employee;
import com.zhang.mp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhl
 * @since 2020-12-30
 */
@Controller
@RequestMapping("/getemps.do")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/getemps.do")
    public String emps(Model model){
        List<Employee> list1= employeeService.getEmps();
        model.addAttribute("allEmps",list1);

        return "list";

    }
}

