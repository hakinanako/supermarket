// Java
package org.hakiko.supermarket.entity;

import lombok.Data;

@Data
public class User {
    private int userID;
    private int employeeID;
    private String username;
    private String password;
    private boolean isDeleted;
}