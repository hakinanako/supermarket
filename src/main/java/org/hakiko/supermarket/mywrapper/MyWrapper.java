package org.hakiko.supermarket.mywrapper;

import java.util.function.Function;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface MyWrapper<T> {
    MyWrapper<T> eq(Function<T, String> fieldSelector, Object value);
    MyWrapper<T> ne(Function<T, String> fieldSelector, Object value);
    MyWrapper<T> gt(Function<T, String> fieldSelector, Object value);
    MyWrapper<T> ge(Function<T, String> fieldSelector, Object value);
    MyWrapper<T> lt(Function<T, String> fieldSelector, Object value);
    MyWrapper<T> le(Function<T, String> fieldSelector, Object value);
    MyWrapper<T> like(Function<T, String> fieldSelector, String value);
    String getSql();
    List<Object> getParams();
    PreparedStatement prepareStatement(Connection connection) throws SQLException;
}