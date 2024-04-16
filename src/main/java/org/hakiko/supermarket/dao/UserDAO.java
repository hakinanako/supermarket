// Java
package org.hakiko.supermarket.dao;

import org.hakiko.supermarket.entity.User;
import org.hakiko.supermarket.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends BaseDAO<User> {

    public List<User> findAll() throws SQLException {
        String sql = "SELECT * FROM Users WHERE IsDeleted = 0";
        try (Connection connection = JDBCUtil.getConnection()) {
            return getBeanList(connection, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int insert(User user) throws SQLException {
        String sql = "INSERT INTO Users (EmployeeID, Username, Password, IsDeleted) VALUES (?, ?, ?, ?)";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, user.getEmployeeID());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setBoolean(4, user.isDeleted());
            return pstmt.executeUpdate();
        }
    }

    public int update(User user) throws SQLException {
        String sql = "UPDATE Users SET EmployeeID = ?, Username = ?, Password = ?, IsDeleted = ? WHERE UserID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, user.getEmployeeID());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getPassword());
            pstmt.setBoolean(4, user.isDeleted());
            pstmt.setInt(5, user.getUserID());
            return pstmt.executeUpdate();
        }
    }

    public int delete(int id) throws SQLException {
        String sql = "UPDATE Users SET IsDeleted = 1 WHERE UserID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        }
    }
}