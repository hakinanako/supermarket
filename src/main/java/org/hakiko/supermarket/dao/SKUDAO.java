
package org.hakiko.supermarket.dao;

import org.hakiko.supermarket.entity.SKU;
import org.hakiko.supermarket.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SKUDAO extends BaseDAO<SKU> {

    public List<SKU> findAll() throws SQLException {
        String sql = "SELECT * FROM sku WHERE IsDeleted = 0";
        try (Connection connection = JDBCUtil.getConnection()) {
            return getBeanList(connection, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int insert(SKU sku) throws SQLException {
        String sql = "INSERT INTO sku (SPU_ID, SKU_Name, Attributes, Price, StockQuantity, ImageURL, Remark, IsDeleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, sku.getSkuID());
            pstmt.setString(2, sku.getSkuName());
            pstmt.setString(3, sku.getAttributes());
            pstmt.setBigDecimal(4, sku.getPrice());
            pstmt.setInt(5, sku.getStockQuantity());
            pstmt.setString(6, sku.getImageURL());
            pstmt.setString(7, sku.getRemark());
            pstmt.setBoolean(8, sku.isDeleted());
            return pstmt.executeUpdate();
        }
    }

    public int update(SKU sku) throws SQLException {
        String sql = "UPDATE sku SET SPU_ID = ?, SKU_Name = ?, Attributes = ?, Price = ?, StockQuantity = ?, ImageURL = ?, Remark = ?, IsDeleted = ? WHERE SKU_ID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, sku.getSpuID());
            pstmt.setString(2, sku.getSkuName());
            pstmt.setString(3, sku.getAttributes());
            pstmt.setBigDecimal(4, sku.getPrice());
            pstmt.setInt(5, sku.getStockQuantity());
            pstmt.setString(6, sku.getImageURL());
            pstmt.setString(7, sku.getRemark());
            pstmt.setBoolean(8, sku.isDeleted());
            pstmt.setInt(9, sku.getSkuID());
            return pstmt.executeUpdate();
        }
    }

    public int delete(int id) throws SQLException {
        String sql = "UPDATE sku SET IsDeleted = 1 WHERE SKU_ID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        }
    }
}