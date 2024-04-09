package org.hakiko.supermarket.mywrapper;

import org.hakiko.supermarket.myannotation.ToUnderScore;
import org.hakiko.supermarket.utils.NameConversionUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MyWrapperInvocationHandler implements InvocationHandler {
    private final MyWrapper<?> target;

    public MyWrapperInvocationHandler(MyWrapper<?> target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].isAnnotationPresent(ToUnderScore.class) && args[i] instanceof String fields) {
                String[] fieldNames = fields.split(",");
                StringBuilder dbFields = new StringBuilder();
                for (String fieldName : fieldNames) {
                    String columnName = NameConversionUtil.camelToUnderscore(fieldName.trim());
                    dbFields.append(columnName).append(",");
                }
                if (!dbFields.isEmpty()) {
                    dbFields.setLength(dbFields.length() - 1);
                }
                args[i] = dbFields.toString();
            }
        }

        if (target.getClass().isAnnotationPresent(ToUnderScore.class)) {
            Field[] fields = target.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String columnName = NameConversionUtil.camelToUnderscore(field.getName());
                field.set(target, columnName);
            }
        }

        return method.invoke(target, args);
    }
}