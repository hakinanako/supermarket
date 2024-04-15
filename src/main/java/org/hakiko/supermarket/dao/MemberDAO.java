// Java
package org.hakiko.supermarket.dao;

import org.hakiko.supermarket.entity.Member;
import org.hakiko.supermarket.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MemberDAO extends BaseDAO<Member> {

    public List<Member> findAll() throws SQLException {
        String sql = "SELECT * FROM members WHERE IsDeleted = 0";
        try (Connection connection = JDBCUtil.getConnection()) {
            return getBeanList(connection, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int insert(Member member) throws SQLException {
        String sql = "INSERT INTO members (Name, Email, PhoneNumber, RegistrationDate, MemberLevel, Remark, IsDeleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPhoneNumber());
            pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(member.getRegistrationDate()));
            pstmt.setString(5, member.getMemberLevel());
            pstmt.setString(6, member.getRemark());
            pstmt.setBoolean(7, member.isDeleted());
            return pstmt.executeUpdate();
        }
    }

    public int update(Member member) throws SQLException {
        String sql = "UPDATE members SET Name = ?, Email = ?, PhoneNumber = ?, RegistrationDate = ?, MemberLevel = ?, Remark = ?, IsDeleted = ? WHERE MemberID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPhoneNumber());
            pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(member.getRegistrationDate()));
            pstmt.setString(5, member.getMemberLevel());
            pstmt.setString(6, member.getRemark());
            pstmt.setBoolean(7, member.isDeleted());
            pstmt.setInt(8, member.getMemberID());
            return pstmt.executeUpdate();
        }
    }

    public int delete(int id) throws SQLException {
        String sql = "UPDATE members SET IsDeleted = 1 WHERE MemberID = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        }
    }
}