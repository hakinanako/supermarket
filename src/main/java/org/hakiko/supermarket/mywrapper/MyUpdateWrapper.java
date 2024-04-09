package org.hakiko.supermarket.mywrapper;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MyUpdateWrapper<T> implements MyWrapper<T> {
    private final StringBuilder set = new StringBuilder();
    private final StringBuilder where = new StringBuilder();
    private final List<Object> params = new ArrayList<>();

    public MyUpdateWrapper(Class<T> type) {
    }

    public MyUpdateWrapper<T> set(Function<T, String> fieldSelector, Object value) {
        set.append(fieldSelector.apply(null)).append(" = ? , ");
        params.add(value);
        return this;
    }

    public MyUpdateWrapper<T> eq(Function<T, String> fieldSelector, Object value) {
        where.append(fieldSelector.apply(null)).append(" = ? AND ");
        params.add(value);
        return this;
    }

    public MyUpdateWrapper<T> ne(Function<T, String> fieldSelector, Object value) {
        where.append(fieldSelector.apply(null)).append(" <> ? AND ");
        params.add(value);
        return this;
    }

    public MyUpdateWrapper<T> gt(Function<T, String> fieldSelector, Object value) {
        where.append(fieldSelector.apply(null)).append(" > ? AND ");
        params.add(value);
        return this;
    }

    public MyUpdateWrapper<T> ge(Function<T, String> fieldSelector, Object value) {
        where.append(fieldSelector.apply(null)).append(" >= ? AND ");
        params.add(value);
        return this;
    }

    public MyUpdateWrapper<T> lt(Function<T, String> fieldSelector, Object value) {
        where.append(fieldSelector.apply(null)).append(" < ? AND ");
        params.add(value);
        return this;
    }

    public MyUpdateWrapper<T> le(Function<T, String> fieldSelector, Object value) {
        where.append(fieldSelector.apply(null)).append(" <= ? AND ");
        params.add(value);
        return this;
    }

    public MyUpdateWrapper<T> like(Function<T, String> fieldSelector, String value) {
        where.append(fieldSelector.apply(null)).append(" LIKE ? AND ");
        params.add(value);
        return this;
    }

    public String getSql() {
        StringBuilder sql = new StringBuilder();
        if (!set.isEmpty()) {
            sql.append("UPDATE ").append(set.substring(0, set.length() - 3));
        }
        if (!where.isEmpty()) {
            sql.append(" WHERE ").append(where.substring(0, where.length() - 5));
        }
        return sql.toString();
    }

    public List<Object> getParams() {
        return params;
    }

    public PreparedStatement prepareStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getSql());
        for (int i = 0; i < params.size(); i++) {
            statement.setObject(i + 1, params.get(i));
        }
        return statement;
    }
}