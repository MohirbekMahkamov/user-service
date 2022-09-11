package com.example.userservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Department {

    private int id;

    private String DepartmentName;
    private String DepartmentAddress;
    private String DepartmentCode;



}
