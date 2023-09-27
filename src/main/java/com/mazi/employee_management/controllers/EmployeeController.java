package com.mazi.employee_management.controllers;

import com.mazi.employee_management.models.Employee;
import com.mazi.employee_management.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees(){
      return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee>getEmployee(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(id));
    }
    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
         Employee newEmployee = employeeService.createEmployee(employee);
         return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(employee,id));
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String,String>>deleteEmployee(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteEmployee(id));
    }
}
