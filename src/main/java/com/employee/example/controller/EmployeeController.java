package com.employee.example.controller;

import com.employee.example.entity.Employee;
import com.employee.example.entity.EmployeeResponse;
import com.employee.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
   public Employee addEmployee(@RequestBody Employee employee) {
      return employeeService.addEmployee(employee);
   }

   @GetMapping("/allEmployees")
    List<Employee> getAllEmployees(){
        return  employeeService.getAllEmployees();
   }

   @GetMapping("/getStatusCodeAlongWithEntity")
    public ResponseEntity<Employee> hello(){
        Employee emp = Employee.builder()
                .name("mama")
                .department("CSE")
                .build();

        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
   }
}
