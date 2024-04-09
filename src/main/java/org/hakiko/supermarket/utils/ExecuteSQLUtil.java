// Java
package org.hakiko.supermarket.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class ExecuteSQLUtil {
    public static <R> R executeQuery(String sql, Function<ResultSet, R> handler) {
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            return handler.apply(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}