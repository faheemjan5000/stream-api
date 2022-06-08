package com.employee.example;

import com.employee.example.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class EmpolyeeTest {

    @Autowired
    MockMvc mockMvc;

    private Employee employee;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    public void setEmployee(){
         employee = new Employee();
        employee.setDepartment("computer");
        employee.setName("khan");
    }

    @Test
    public void addEmployeeTest() throws Exception {
        //before sending the post request convert the raw object into json
    String employeeAsString = objectMapper.writeValueAsString(employee);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/Employee/add")
                .content(employeeAsString)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        //getting the response(json) from mvcResult.
        String responseContent = mvcResult.getResponse().getContentAsString();
        //convert the response into object through objectMapper.
        Employee emp = objectMapper.readValue(responseContent,Employee.class);
        assertEquals("khan" , emp.getName());
    }

    @Test
    public void getAllEmployeesTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/Employee/allEmployees")
               // .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
       // List<Employee> employeeList = objectMapper.readValue(response,Employee.class);
    }



}
