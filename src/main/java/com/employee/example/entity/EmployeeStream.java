package com.employee.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeStream {

    private String firstName;
    private String lastName;
    private Double salary;
    private List<String> projects;

    public EmployeeStream(String firstName, String lastName, double salary, List<String> projects) {
        this.firstName =firstName;
        this.lastName=lastName;
        this.salary=salary;
        this.projects=projects;
    }
}
