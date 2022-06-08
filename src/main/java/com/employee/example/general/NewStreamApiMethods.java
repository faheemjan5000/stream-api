package com.employee.example.general;

import com.employee.example.entity.EmployeeStream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NewStreamApiMethods {

    private static List<EmployeeStream> employees = new LinkedList<>();

    public static void main(String[] args){
        initializeDB();
        //filterEmployees();
        //mapEmployee();
        //printOnlyProjects();
       // printProjectsOfLuca();
        addProjectForLuca();
    }
   public static void addProjectForLuca(){
        //first filter luca
       List<EmployeeStream> lucaList = employees.stream()
               .filter(emp->emp.getFirstName().equalsIgnoreCase("luca"))
               .collect(Collectors.toList());
       lucaList.stream()
               .forEach(emp->System.out.println(emp.getFirstName()+"-"+emp.getLastName() + " projects : " +emp.getProjects()));
       System.out.println("*******************************");
       lucaList.stream()
               .forEach(luca->luca.addNewProject("project10"));
       lucaList.stream()
               .forEach(emp->System.out.println(emp.getFirstName()+"-"+emp.getLastName() + " projects : " +emp.getProjects()));



   }
    public static void printProjectsOfLuca(){
      //first filter for luca
        List<EmployeeStream> lucaList = employees.stream()
                 .filter(emp->emp.getFirstName().equalsIgnoreCase("luca"))
                .collect(Collectors.toList());
        lucaList.stream()
                .forEach(emp->System.out.println(emp.getFirstName()+"-"+emp.getLastName() + " projects : " +emp.getProjects()));
    }
    public static void printOnlyProjects(){
        employees.stream()
                 .forEach(emp->System.out.println(emp.getFirstName()+"-"+emp.getLastName() + " projects : " +emp.getProjects()));
    }
    public static void mapEmployee(){
        //increase salary by 10%
       List<EmployeeStream> mappedEmployee = employees.stream()
                .map(emp->new EmployeeStream( emp.getFirstName(),emp.getLastName(),emp.getSalary()*10,emp.getProjects() ))
                .collect(Collectors.toList());
       mappedEmployee.stream()
                    .forEach(emp->System.out.println(emp));
    }

    public static void filterEmployees(){
       List<EmployeeStream> filteredEmployees = employees.stream()
                 .filter(emp->emp.getSalary()>500)
                .collect(Collectors.toList());
       filteredEmployees.stream()
               .forEach(emp -> System.out.println(emp));
    }

    public static void initializeDB(){
        List<String> e1Projects = new ArrayList<>();
        e1Projects.add("project 1");
        e1Projects.add("project 2");

        List<String> e2Projects = new ArrayList<>();
        e2Projects.add("project 1");
        e2Projects.add("project 3");

        List<String> e3Projects = new ArrayList<>();
        e3Projects.add("project 3");
        e3Projects.add("project 4");

        employees.add(new EmployeeStream("faheem","jan",1000.0,e1Projects));
        employees.add(new EmployeeStream("shabir","khan",500,e2Projects));
        employees.add(new EmployeeStream("Luca","mona",300,e3Projects));
        employees.add(new EmployeeStream("Luca","carlo",600,e2Projects));

    }
}
