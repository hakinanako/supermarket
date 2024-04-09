// Java
package org.hakiko.supermarket.dao;

import org.hakiko.supermarket.bean.Employee;
import org.hakiko.supermarket.mywrapper.MyQueryWrapper;
import org.hakiko.supermarket.utils.ExecuteSQLUtil;
import org.hakiko.supermarket.utils.JDBCUtil;
import org.hakiko.supermarket.utils.LoggerUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public List<Employee> findAll() {
        MyQueryWrapper<Employee> queryWrapper = new MyQueryWrapper<>(Employee.class);
        String sql = queryWrapper.select(Employee::getName).getSql();

        return ExecuteSQLUtil.executeQuery(sql, rs -> {
            List<Employee> employees = new ArrayList<>();
            try {
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setName(rs.getString("name"));
                    employees.add(employee);
                }
            } catch (SQLException e) {
                LoggerUtil.logError(e);
            }
            return employees;
        });
    }
}