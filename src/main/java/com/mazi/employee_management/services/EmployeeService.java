package com.mazi.employee_management.services;
import com.mazi.employee_management.models.Employee;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee createEmployee(Employee employee);


    Employee getEmployee(Long id);

    Employee updateEmployee(Employee employee, Long id);

    Map<String,String> deleteEmployee(Long id);
}
