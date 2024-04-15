package org.hakiko.supermarket.dao;

import org.hakiko.supermarket.entity.Transaction;
import org.hakiko.supermarket.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TransactionDAO extends BaseDAO<Transaction> {

    public List<Transaction> findAll() throws SQLException {
        String sql = "SELECT * FROM transactions WHERE IsDeleted = 0";
        try (Connection connection = JDBCUtil.getConnection()) {
            return getBeanList(connection, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int insert(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transactions (TotalAmount, TransactionDate, Balance, EmployeeID, Remark, IsDeleted) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setBigDecimal(1, transaction.getTotalAmount());
            pstmt.setTimestamp(2, java.sql.Timestamp.valueOf(transaction.getTransactionDate()));
            pstmt.setBigDecimal(3, transaction.getBalance());
            pstmt.setInt(4, transaction.getEmployeeID());
            pstmt.setString(5, transaction.getRemark());
            pstmt.setBoolean(6, transaction.isDeleted());
            return pstmt.executeUpdate();
        }
    }

    public int update(Transaction transaction) throws SQLException {
        String sql = "UPDATE transactions SET TotalAmount = ?, TransactionDate = ?, Balance = ?, EmployeeID = ?, Remark = ?, IsDeleted = ? WHERE TransactionID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setBigDecimal(1, transaction.getTotalAmount());
            pstmt.setTimestamp(2, java.sql.Timestamp.valueOf(transaction.getTransactionDate()));
            pstmt.setBigDecimal(3, transaction.getBalance());
            pstmt.setInt(4, transaction.getEmployeeID());
            pstmt.setString(5, transaction.getRemark());
            pstmt.setBoolean(6, transaction.isDeleted());
            pstmt.setInt(7, transaction.getTransactionID());
            return pstmt.executeUpdate();
        }
    }

    public int delete(int id) throws SQLException {
        String sql = "UPDATE transactions SET IsDeleted = 1 WHERE TransactionID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        }
    }
}