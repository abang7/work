package com.bang.reggie.service;

import com.bang.reggie.common.R;
import com.bang.reggie.entity.Employee;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

public interface EmployeeService {
    Employee get(Long id);
    void delete(Long id);
    R<Employee> login(HttpServletRequest httpServletRequest, Employee employee);
}
