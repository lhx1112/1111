package com.jsp.servlet;

import com.jsp.entity.Employee;
import com.jsp.service.EmployeeService;
import com.jsp.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/emps")
public class EmployeeServlet extends HttpServlet {


    private EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 数据一般都是从DB获取，这里我们就模拟一下
        List<Employee> emps = employeeService.queryAll();
        request.setAttribute("emps", emps);
        request.getRequestDispatcher("main.jsp").forward(request, response);

    }

//    public List<Employee> getEmployeesFromDBSimulation(){
//        List<Employee> emps = new ArrayList<>();
//        for (int i = 0; i <= 5; i++) {
//            emps.add(new Employee(i, "emp" + i, 18 + i, "emp" + i + "@163.com"));
//        }
//        return emps;
//    }
}
