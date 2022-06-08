package com.employee.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
                             //used this comaprable to be able to use TreeSet which sort elements in the set based on a comparable
public class EmployeeStream implements Comparable<EmployeeStream> {

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
    public void addNewProject(String project){
        if(projects==null)
            projects = new ArrayList<>();
        projects.add(project);
    }

    @Override
    public int compareTo(EmployeeStream o) {
        return (int) (this.salary-o.getSalary());
    }
}
