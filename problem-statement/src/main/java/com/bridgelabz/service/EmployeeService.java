package com.bridgelabz.service;

import com.bridgelabz.dto.RequestDto;
import com.bridgelabz.entity.Employee;

import java.util.List;

public interface EmployeeService {
    RequestDto addEmployee(RequestDto requestDto);
    List<Employee> getAllEmployee();
    Employee getById( Long id);
    Employee updateById(Long id,Employee employee);
    void deleteById( Long id);
}
