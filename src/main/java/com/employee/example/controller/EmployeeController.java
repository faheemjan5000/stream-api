package com.employee.example.controller;

import com.employee.example.entity.Employee;
import com.employee.example.entity.EmployeeResponse;
import com.employee.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
