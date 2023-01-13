package com.bang.reggie.controller;


import com.bang.reggie.common.R;
import com.bang.reggie.entity.Employee;
import com.bang.reggie.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/Employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/get")
    public String get(){
        return employeeService.get(1L).toString();
    }
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id){
        employeeService.delete(id);
        return "success";
    }
    @PostMapping("/backend/page/login/login.html")
    public R<Employee> login(@RequestBody HttpServletRequest httpServletRequest, Employee employee){
        return employeeService.login(httpServletRequest, employee);
    }
}
