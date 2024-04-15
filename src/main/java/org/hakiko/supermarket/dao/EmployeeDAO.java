// Java
package org.hakiko.supermarket.dao;

import org.hakiko.supermarket.entity.Employee;
import org.hakiko.supermarket.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAO extends BaseDAO<Employee> {

    public List<Employee> findAll() throws SQLException {
        String sql = "SELECT * FROM employees WHERE IsDeleted = 0";
        try (Connection connection = JDBCUtil.getConnection()) {
            return getBeanList(connection, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int insert(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (Name, Position, Email, PhoneNumber, HireDate, Remark, IsDeleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPosition());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getPhoneNumber());
            pstmt.setTimestamp(5, java.sql.Timestamp.valueOf(employee.getHireDate()));
            pstmt.setString(6, employee.getRemark());
            pstmt.setBoolean(7, employee.isDeleted());
            return pstmt.executeUpdate();
        }
    }

    public int update(Employee employee) throws SQLException {
        String sql = "UPDATE employees SET Name = ?, Position = ?, Email = ?, PhoneNumber = ?, HireDate = ?, Remark = ?, IsDeleted = ? WHERE EmployeeID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPosition());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getPhoneNumber());
            pstmt.setTimestamp(5, java.sql.Timestamp.valueOf(employee.getHireDate()));
            pstmt.setString(6, employee.getRemark());
            pstmt.setBoolean(7, employee.isDeleted());
            pstmt.setInt(8, employee.getEmployeeID());
            return pstmt.executeUpdate();
        }
    }

    public int delete(int id) throws SQLException {
        String sql = "UPDATE employees SET IsDeleted = 1 WHERE EmployeeID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        }
    }
}