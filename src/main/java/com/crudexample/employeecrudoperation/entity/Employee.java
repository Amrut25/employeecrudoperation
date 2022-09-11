package com.crudexample.employeecrudoperation.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Getter
//@Setter
//@RequiredArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
//@ToString
//All above Annotations are equal to single annotation @Data,by using @Data we get above all annotations
//These all are Lambok annotations
@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int empId;

    private String empName;
    private String empAddress;
    private long empSalary;
}
