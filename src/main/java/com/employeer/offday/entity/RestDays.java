package com.employeer.offday.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RestDays")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
@ApiModel(value = "Off Days")
public class RestDays implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_restday_id", allocationSize = 2, initialValue = 1000)
    @GeneratedValue(generator = "seq_restday_id", strategy = GenerationType.SEQUENCE)
    @ApiModelProperty(value = "Off Days Record ID")
    @Column(name = "id")
    private int id;

    @ManyToOne
    @ApiModelProperty(value = "Employee Info")
    @JoinColumn(name = "employee_id")
    private Employees employees;

    @ApiModelProperty(value = "Off Day's Date")
    @Column(name = "Date")
    private String date;
}
