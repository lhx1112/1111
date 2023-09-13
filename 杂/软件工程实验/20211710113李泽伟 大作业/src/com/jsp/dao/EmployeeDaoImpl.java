package com.jsp.dao;

import com.jsp.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> queryAll() {
        List<Employee> emps = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            emps.add(new Employee(i, "emp" + i, 18 + i, "emp" + i + "@163.com"));
        }
        return emps;
    }
}
