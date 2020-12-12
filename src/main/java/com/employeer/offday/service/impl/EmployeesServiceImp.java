package com.employeer.offday.service.impl;

import com.employeer.offday.DTO.EmployeesDTO;
import com.employeer.offday.entity.Employees;
import com.employeer.offday.entity.RestDays;
import com.employeer.offday.repo.EmployeesRepository;
import com.employeer.offday.repo.RestDaysRepository;
import com.employeer.offday.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeesServiceImp implements EmployeesService {

    private final EmployeesRepository employeesRepository;
    private final RestDaysRepository restDaysRepository;

    @Override
    @Transactional
    public EmployeesDTO saveEmployee(EmployeesDTO employeeDTO) {
        Assert.notNull(employeeDTO.getName(), "Employee's Name is required");
        Assert.notNull(employeeDTO.getSurname(), "Employee's Surname is required");

        Employees employee = new Employees();
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setAge(employeeDTO.getAge());
        final Employees employeeDB = employeesRepository.save(employee);

        List<RestDays> restDaysList = new ArrayList<>();
        employeeDTO.getEmployeeRestDays().forEach(item -> {
            RestDays restDays = new RestDays();
            restDays.setDate(item);
            restDays.setEmployees(employeeDB);
            restDaysList.add(restDays);
        });
        restDaysRepository.saveAll(restDaysList);
        employeeDTO.setId(employeeDB.getId());
        return employeeDTO;
    }

    @Override
    public EmployeesDTO updateEmployee(EmployeesDTO employeeDTO, int id) {
        Employees employee = employeesRepository.findById(id).get();

        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setAge(employeeDTO.getAge());
        final Employees employeeDB = employeesRepository.save(employee);

        List<RestDays> restDaysList = new ArrayList<>();
        employeeDTO.getEmployeeRestDays().forEach(item -> {
            RestDays restDays = new RestDays();
            restDays.setDate(item);
            restDays.setEmployees(employeeDB);
            restDaysList.add(restDays);
        });
        restDaysRepository.saveAll(restDaysList);
        return employeeDTO;
    }

    @Override
    public List<EmployeesDTO> getAllEmployee() {
        List<Employees> employees = employeesRepository.findAll();
        List<EmployeesDTO> employeesDTOS = new ArrayList<>();

        employees.forEach(showItem -> {
            EmployeesDTO employeesDTO = new EmployeesDTO();
            employeesDTO.setId(showItem.getId());
            employeesDTO.setName(showItem.getName());
            employeesDTO.setSurname(showItem.getSurname());
            employeesDTO.setAge(showItem.getAge());
            employeesDTO.setEmployeeRestDays(showItem.getEmployeeRestDays()
                                             .stream()
                                             .map(RestDays::getDate)
                                             .collect(Collectors.toList()));
            employeesDTOS.add(employeesDTO);
        });
        return employeesDTOS;
    }

    @Override
    public List<EmployeesDTO> getEmployee(int id) {
        List<Employees> employees = employeesRepository.findAllById(Collections.singleton(id));
        List<EmployeesDTO> employeesDTOS = new ArrayList<>();

        employees.forEach(showItem -> {
            EmployeesDTO employeesDTO = new EmployeesDTO();
            employeesDTO.setId(showItem.getId());
            employeesDTO.setName(showItem.getName());
            employeesDTO.setSurname(showItem.getSurname());
            employeesDTO.setAge(showItem.getAge());
            employeesDTO.setEmployeeRestDays(showItem.getEmployeeRestDays()
                    .stream()
                    .map(RestDays::getDate)
                    .collect(Collectors.toList()));
            employeesDTOS.add(employeesDTO);
        });
        return employeesDTOS;
    }

    @Override
    public Map<String, Boolean> deleteEmployee(Integer id) {
        Employees employee = employeesRepository.findById(id).get();
        restDaysRepository.deleteAll(employee.getEmployeeRestDays());
        employeesRepository.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Employee Deleted", Boolean.TRUE);
        return response;
    }

}
