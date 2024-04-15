package org.hakiko.supermarket.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Employee {
    private int employeeID;
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private LocalDateTime hireDate;
    private String remark;
    private boolean isDeleted;
}
