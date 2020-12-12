package com.employeer.offday.DTO;

import com.employeer.offday.entity.Employees;
import lombok.Data;

@Data
public class RestDaysDTO {

    private int id;

    private Employees employees;

    private String date;

}
