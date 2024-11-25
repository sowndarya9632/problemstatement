package com.bridgelabz.service;

import com.bridgelabz.dto.RequestDto;
import com.bridgelabz.entity.Employee;
import com.bridgelabz.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public RequestDto addEmployee(RequestDto requestDto) {
        Employee employee = new Employee(requestDto);
        return mapToDto(employeeRepository.save(employee));
    }

    private RequestDto mapToDto(Employee employee) {
        RequestDto requestDto = new RequestDto();
        requestDto.setFname(employee.getFname());
        requestDto.setLname(employee.getLname());
        requestDto.setSalary(employee.getSalary());
        requestDto.setProfilepic(employee.getProfilepic());
        requestDto.setDepartment(employee.getDepartment());
        requestDto.setGender(employee.getGender());
        requestDto.setNotes(employee.getNotes());
        return requestDto;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateById(Long id, Employee employee) {
        Optional<Employee> exist = employeeRepository.findById(id);
        if (exist.isPresent()) {
            employee.setEmpId(id);
           return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
         employeeRepository.deleteById(id);
    }
}

