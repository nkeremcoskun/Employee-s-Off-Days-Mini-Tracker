package com.employeer.offday.DTO;

import lombok.Data;

import java.util.List;

@Data
public class EmployeesDTO {

    private int id;

    private String name;

    private String surname;

    private int age;

    private List<String> employeeRestDays;

}
