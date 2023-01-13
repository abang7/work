package com.bang.reggie.dao;

import com.bang.reggie.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeByUsernameAndPassword(String username, String password);
}
