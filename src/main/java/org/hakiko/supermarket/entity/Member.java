package org.hakiko.supermarket.entity;// Java

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private int memberID;
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDateTime registrationDate;
    private String memberLevel;
    private String remark;
    private boolean isDeleted;

}