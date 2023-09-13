package chap09.servlet;

import chap09.entity.User;
import chap09.service.UserService;
import chap09.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindUserById2",urlPatterns = "/findUserById2")
public class FindUserById2 extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findUserById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("updateinfo.jsp").forward(request, response);
    }
}
