package com.employeer.offday.service;

import com.employeer.offday.DTO.EmployeesDTO;

import java.util.List;
import java.util.Map;

public interface EmployeesService {

    EmployeesDTO saveEmployee(EmployeesDTO employeeDTO);

    EmployeesDTO updateEmployee(EmployeesDTO employeesDTO, int id);

    List<EmployeesDTO> getEmployee(int id);

    List<EmployeesDTO> getAllEmployee();

    Map<String, Boolean> deleteEmployee(Integer id);
}
