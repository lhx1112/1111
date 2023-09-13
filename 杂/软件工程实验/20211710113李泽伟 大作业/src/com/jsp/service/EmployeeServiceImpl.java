package com.jsp.service;

import com.jsp.dao.EmployeeDao;
import com.jsp.dao.EmployeeDaoImpl;
import com.jsp.entity.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public List<Employee> queryAll() {
        return employeeDao.queryAll();
    }
}
