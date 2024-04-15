package org.hakiko.supermarket.dao;

import org.hakiko.supermarket.entity.OrderDetail;
import org.hakiko.supermarket.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAO extends BaseDAO<OrderDetail> {

    public List<OrderDetail> findAll() throws SQLException {
        String sql = "SELECT * FROM OrderDetails WHERE IsDeleted = 0";
        try (Connection connection = JDBCUtil.getConnection()) {
            return getBeanList(connection, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int insert(OrderDetail orderDetail) throws SQLException {
        String sql = "INSERT INTO order_details (OrderID, SKU_ID, Quantity, Price, Subtotal, Remark, IsDeleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, orderDetail.getOrderID());
            pstmt.setInt(2, orderDetail.getSkuID());
            pstmt.setInt(3, orderDetail.getQuantity());
            pstmt.setBigDecimal(4, orderDetail.getPrice());
            pstmt.setBigDecimal(5, orderDetail.getSubtotal());
            pstmt.setString(6, orderDetail.getRemark());
            pstmt.setBoolean(7, orderDetail.isDeleted());
            return pstmt.executeUpdate();
        }
    }

    public int update(OrderDetail orderDetail) throws SQLException {
        String sql = "UPDATE order_details SET OrderID = ?, SKU_ID = ?, Quantity = ?, Price = ?, Subtotal = ?, Remark = ?, IsDeleted = ? WHERE OrderDetailID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, orderDetail.getOrderID());
            pstmt.setInt(2, orderDetail.getSkuID());
            pstmt.setInt(3, orderDetail.getQuantity());
            pstmt.setBigDecimal(4, orderDetail.getPrice());
            pstmt.setBigDecimal(5, orderDetail.getSubtotal());
            pstmt.setString(6, orderDetail.getRemark());
            pstmt.setBoolean(7, orderDetail.isDeleted());
            pstmt.setInt(8, orderDetail.getOrderDetailID());
            return pstmt.executeUpdate();
        }
    }

    public int delete(int id) throws SQLException {
        String sql = "UPDATE order_details SET IsDeleted = 1 WHERE OrderDetailID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        }
    }
}