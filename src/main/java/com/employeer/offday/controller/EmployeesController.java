package com.employeer.offday.controller;

import com.employeer.offday.DTO.EmployeesDTO;
import com.employeer.offday.service.EmployeesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@Api(value = "Employees Rest Days Api")
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeesService employeesService;

    @PostMapping
    @ApiOperation(value = "New Employee")
    public ResponseEntity<EmployeesDTO> saveEmployees(@RequestBody EmployeesDTO employeesDTO) {
        return ResponseEntity.ok(employeesService.saveEmployee(employeesDTO));
    }

    @GetMapping
    @ApiOperation(value = "Show Employees")
    public ResponseEntity<List<EmployeesDTO>> getAllEmployees(){
        return ResponseEntity.ok(employeesService.getAllEmployee());
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "Find Employee by ID")
    public ResponseEntity<List<EmployeesDTO>> getEmployee(@PathVariable int id){
        return ResponseEntity.ok(employeesService.getEmployee(id));
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Update Employee Informations by ID")
    public ResponseEntity<EmployeesDTO> updateEmployee(@RequestBody EmployeesDTO employeesDTO,@PathVariable Integer id){
        return ResponseEntity.ok(employeesService.updateEmployee(employeesDTO,id));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete Employee by ID")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Integer id){
        return ResponseEntity.ok(employeesService.deleteEmployee(id));
    }
}
