package com.bang.reggie.service.Impl;
import com.bang.reggie.common.R;
import com.bang.reggie.dao.EmployeeRepository;
import com.bang.reggie.entity.Employee;
import com.bang.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee get(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public R<Employee> login(HttpServletRequest httpServletRequest, Employee employee) {
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        Employee target = employeeRepository.findEmployeeByUsernameAndPassword(employee.getUsername(), password);
        if (target != null && target.getStatus() == 1) {
            return R.success(target);
        } else {
            return R.error("登录失败");
        }

    }
}
