package com.employeer.offday.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
@ApiModel(value = "Employees")
public class Employees{

    @Id
    @SequenceGenerator(name = "seq_employee_id", allocationSize = 5, initialValue = 100)
    @GeneratedValue(generator = "seq_employee_id", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @ApiModelProperty(value = "Employee Name")
    @Column(name = "EmployeeName", nullable = false, length = 100)
    private String name;

    @ApiModelProperty(value = "Employee Surname")
    @Column(name = "EmployeeSurname", nullable = false, length = 100)
    private String surname;

    @ApiModelProperty(value = "Employee Age")
    @Column(name = "EmployeeAge", nullable = false)
    private int age;

    @ApiModelProperty(value = "Employee Off Days")
    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<RestDays> employeeRestDays;
}
