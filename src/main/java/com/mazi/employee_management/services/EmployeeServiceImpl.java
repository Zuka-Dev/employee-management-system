package com.mazi.employee_management.services;

import com.mazi.employee_management.exceptions.EmployeeExistsException;
import com.mazi.employee_management.exceptions.EmployeeNotFoundException;
import com.mazi.employee_management.models.Employee;
import com.mazi.employee_management.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        if (isEmailAlreadyExists(employee.getEmail())) {
            throw new EmployeeExistsException("Employee already Exists");
        }
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(
                        () -> new EmployeeNotFoundException("This Employee does not exist")
                );
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee existingEmployee = getEmployee(id);
        if (existingEmployee == null) {
         new EmployeeNotFoundException("This Employee does not exist");

        }
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public Map<String, String> deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        Map<String, String> map = new HashMap<>();
        map.put("message","User with ID " + id + " has been deleted successfully");
        return map;
        }



    public boolean isEmailAlreadyExists(String email) {
        Employee existingEmployee = employeeRepository.findByEmail(email);
        return existingEmployee != null;
    }
}
