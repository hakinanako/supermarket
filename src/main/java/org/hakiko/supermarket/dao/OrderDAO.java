package org.hakiko.supermarket.dao;


import org.hakiko.supermarket.entity.Order;
import org.hakiko.supermarket.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO extends BaseDAO<Order> {

    public List<Order> findAll() throws SQLException {
        String sql = "SELECT * FROM Orders WHERE IsDeleted = 0";
        try (Connection connection = JDBCUtil.getConnection()) {
            return getBeanList(connection, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int insert(Order order) throws SQLException {
        String sql = "INSERT INTO orders (TransactionID, EmployeeID, OrderDate, TotalAmount, Remark, IsDeleted) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, order.getTransactionID());
            pstmt.setInt(2, order.getEmployeeID());
            pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(order.getOrderDate()));
            pstmt.setBigDecimal(4, order.getTotalAmount());
            pstmt.setString(5, order.getRemark());
            pstmt.setBoolean(6, order.isDeleted());
            return pstmt.executeUpdate();
        }
    }

    public int update(Order order) throws SQLException {
        String sql = "UPDATE orders SET TransactionID = ?, EmployeeID = ?, OrderDate = ?, TotalAmount = ?, Remark = ?, IsDeleted = ? WHERE OrderID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, order.getTransactionID());
            pstmt.setInt(2, order.getEmployeeID());
            pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(order.getOrderDate()));
            pstmt.setBigDecimal(4, order.getTotalAmount());
            pstmt.setString(5, order.getRemark());
            pstmt.setBoolean(6, order.isDeleted());
            pstmt.setInt(7, order.getOrderID());
            return pstmt.executeUpdate();
        }
    }

    public int delete(int id) throws SQLException {
        String sql = "UPDATE orders SET IsDeleted = 1 WHERE OrderID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        }
    }
}