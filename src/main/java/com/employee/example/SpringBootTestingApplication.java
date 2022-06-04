package com.employee.example;

import com.employee.example.entity.Employee;
import com.employee.example.entity.EmployeeStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootTestingApplication {
	static List<EmployeeStream> employees = new ArrayList<>();
	public static void main(String[] args) {
		//SpringApplication.run(SpringBootTestingApplication.class, args);

		initializeDB();
		//to creat a stream of objects, you must use Stream interface and pass a collection/list to it. as below
		//Stream.of(employees); //it gets us stream of employees.
		//or we can use below to get the same result
		//employees.stream();

		//1. for each loop
		System.out.println("forEach : *********************************************");
		employees.stream()
				.forEach(employe->System.out.println(employe));

		//2.map : it maps one object with another object and return the stream. get each employee and increase its salary by 10%
		System.out.println("map : *********************************************");
		List<EmployeeStream> updatedEmployees =employees.stream()
				.map(employee->
						new EmployeeStream(employee.getFirstName(),
								           employee.getLastName(),
								           employee.getSalary()*1.10,
								           employee.getProjects()))  //if not used collect, it returns stream.
		                                   .collect(Collectors.toList()); //if use collect it will return list of employees with different salary

          updatedEmployees.stream() //here we get the stream of employees again to use forEach method and other methods.
				          .forEach(emp->System.out.println(emp));
          //or use System.out.println(updatedEmployees);

		//3.Filter : increase salary of the employee whose salary is greater than 400

		System.out.println("Filter : *********************************************");
		List<EmployeeStream> salaryIncreasedFilter = employees.stream()
				 .filter(emp->emp.getSalary()>400) //it also returns stream so we can use stream immediate methods.
				.map(employee->
						new EmployeeStream(employee.getFirstName(),
								employee.getLastName(),
								employee.getSalary()*1.10,
								employee.getProjects()))
				.collect(Collectors.toList());
		salaryIncreasedFilter.stream()
				         .forEach(emp->System.out.println(emp));

		//findFirst : will get the first item out of the list
		System.out.println("findFirst : *********************************************");
		int maxSalary = 10000;
		EmployeeStream firstEmployee =employees.stream()
				.filter(emp->emp.getSalary()>maxSalary)
				.findFirst()
				.orElse(null);
		if(firstEmployee!=null) {
			System.out.println("first employee is : " + firstEmployee);
		}
		else{
			System.out.println("There is no Employee with salary higher than "+maxSalary);
		}



       //flat map
		System.out.println("flatMap : *********************************************");
		String projects = employees.stream()
				 .map(employee->employee.getProjects())
				.flatMap(strings->strings.stream())
				.collect(Collectors.joining(","));
		System.out.println();

		System.out.println("Mappppppppppppppppppppppppp");
		Map<String ,String> m = new HashMap<>();
		m.put("f","faheem");
		m.put("n","nadee");
		for(String s :m.keySet()){
			System.out.println("Map key :"+s);
		}
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



	}



}
