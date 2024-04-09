package org.hakiko.supermarket.utils;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultUtil {
    public static <T> T mapRow(ResultSet rs, Class<T> outputClass) {
        try {
            T instance = outputClass.getDeclaredConstructor().newInstance();
            Field[] fields = outputClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String columnName = NameConversionUtil.underscoreToCamel(field.getName());
                Object value = rs.getObject(columnName);
                field.set(instance, value);
            }
            return instance;
        } catch (InstantiationException | IllegalAccessException | SQLException | NoSuchMethodException |
                 InvocationTargetException e) {
            LoggerUtil.logError(e);
            return null;
        }
    }
}