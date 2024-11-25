package com.bridgelabz.entity;

import com.bridgelabz.dto.RequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long empId;

    private String fname;
    private String lname;
    private double salary;
    private String profilepic;
    private String department;
    private LocalDate doj;
    private String notes;
    private String gender;
    public Employee(RequestDto requestDto)
    {
        this.fname =requestDto.getFname();
        this.lname=requestDto.getLname();
        this.salary=requestDto.getSalary();
        this.profilepic=requestDto.getProfilepic();
        this.department=requestDto.getDepartment();
        this.gender=requestDto.getGender();
        this.notes=requestDto.getNotes();
        this.doj=LocalDate.now();

    }

}