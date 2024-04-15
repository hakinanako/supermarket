// Java
package org.hakiko.supermarket.dao;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> {
    private final Class<T> type;

    public BaseDAO(){
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();
        this.type = (Class<T>) types[0];
    }

    public int update(Connection connection, String sql, Object... params) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            return statement.executeUpdate();
        }
    }


    public List<T> getBeanList(Connection connection, String sql, Object... params) throws Exception {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                List<T> list = new ArrayList<>();
                ResultSetMetaData metaData = resultSet.getMetaData();
                while (resultSet.next()) {
                    T bean = type.getDeclaredConstructor().newInstance();
                    for (PropertyDescriptor pd : Introspector.getBeanInfo(type).getPropertyDescriptors()) {
                        if (pd.getWriteMethod() != null) {
                            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                                if (pd.getName().equalsIgnoreCase(metaData.getColumnName(i))) {
                                    pd.getWriteMethod().invoke(bean, resultSet.getObject(i));
                                }
                            }
                        }
                    }
                    list.add(bean);
                }
                return list;
            }
        }
    }

    public Object getValue(Connection connection, String sql, Object... params) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getObject(1);
                }
                return null;
            }
        }
    }
}