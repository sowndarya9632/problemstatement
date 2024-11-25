package com.bridgelabz.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    @NotNull(message="message not null")
    private String fname;
    private String lname;
    private double salary;
    private String profilepic;
    private String department;
    private String notes;
    private String gender;

}
