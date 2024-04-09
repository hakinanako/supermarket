package org.hakiko.supermarket.mywrapper;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Data
public class MyQueryWrapper<T> implements MyWrapper<T> {
    private final StringBuilder select = new StringBuilder();
    private final StringBuilder where = new StringBuilder();
    private final StringBuilder groupBy = new StringBuilder();
    private final StringBuilder having = new StringBuilder();
    private final StringBuilder orderBy = new StringBuilder();
    private final List<Object> params = new ArrayList<>();

    public MyQueryWrapper(Class<T> type) {
    }

    public MyQueryWrapper<T> select(Function<T, String> fieldSelector) {
        select.append("SELECT ").append(fieldSelector.apply(null));
        return this;
    }

    public MyQueryWrapper<T> eq(Function<T, String> fieldSelector, Object value) {
        where.append(fieldSelector.apply(null)).append(" = ? AND ");
        params.add(value);
        return this;
    }

    public MyQueryWrapper<T> ne(Function<T, String> fieldSelector, Object value) {
        where.append(fieldSelector.apply(null)).append(" <> ? AND ");
        params.add(value);
        return this;
    }

    public MyQueryWrapper<T> gt(Function<T, String> fieldSelector, Object value) {
        where.append(fieldSelector.apply(null)).append(" > ? AND ");
        params.add(value);
        return this;
    }

    public MyQueryWrapper<T> ge(Function<T, String> fieldSelector, Object value) {
        where.append(fieldSelector.apply(null)).append(" >= ? AND ");
        params.add(value);
        return this;
    }

    public MyQueryWrapper<T> lt(Function<T, String> fieldSelector, Object value) {
        where.append(fieldSelector.apply(null)).append(" < ? AND ");
        params.add(value);
        return this;
    }

    public MyQueryWrapper<T> le(Function<T, String> fieldSelector, Object value) {
        where.append(fieldSelector.apply(null)).append(" <= ? AND ");
        params.add(value);
        return this;
    }

    public MyQueryWrapper<T> like(Function<T, String> fieldSelector, String value) {
        where.append(fieldSelector.apply(null)).append(" LIKE ? AND ");
        params.add(value);
        return this;
    }

    public MyQueryWrapper<T> groupBy(Function<T, String> fieldSelector) {
        groupBy.append(" GROUP BY ").append(fieldSelector.apply(null));
        return this;
    }

    public MyQueryWrapper<T> having(String condition) {
        having.append(" HAVING ").append(condition);
        return this;
    }

    public MyQueryWrapper<T> orderBy(Function<T, String> fieldSelector) {
        orderBy.append(" ORDER BY ").append(fieldSelector.apply(null));
        return this;
    }

    public String getSql() {
        StringBuilder sql = new StringBuilder();
        if (!select.isEmpty()) {
            sql.append(select);
        }
        if (!where.isEmpty()) {
            sql.append(" WHERE ").append(where.substring(0, where.length() - 5));
        }
        if (!groupBy.isEmpty()) {
            sql.append(groupBy);
        }
        if (!having.isEmpty()) {
            sql.append(having);
        }
        if (!orderBy.isEmpty()) {
            sql.append(orderBy);
        }
        return sql.toString();
    }

    public PreparedStatement prepareStatement(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(getSql());
        for (int i = 0; i < params.size(); i++) {
            statement.setObject(i + 1, params.get(i));
        }
        return statement;
    }
}