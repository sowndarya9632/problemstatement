package com.bridgelabz.controller;

import com.bridgelabz.dto.RequestDto;
import com.bridgelabz.entity.Employee;
import com.bridgelabz.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RequestDto addEmployee(@Valid  @RequestBody RequestDto requestDto) {
        return employeeService.addEmployee(requestDto);
    }
        @GetMapping
        public List<Employee> getAllEmployee(){

            return employeeService.getAllEmployee();

        }
        @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id){
        return employeeService.getById(id);
        }
        @PutMapping ("/{id}")
        public Employee updateById(@PathVariable Long id,@RequestBody Employee employee){
        return employeeService.updateById(id,employee);

        }
        @DeleteMapping("/{id}")
        public void deleteById(@PathVariable Long id){
        employeeService.deleteById(id);

        }
    }

