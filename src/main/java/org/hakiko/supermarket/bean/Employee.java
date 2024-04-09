package org.hakiko.supermarket.bean;

import lombok.Data;
import java.util.Date;
@Data
public class Employee {
    private int employeeID;
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String remark;
    private int isDeleted;
}