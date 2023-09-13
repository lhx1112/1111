package chap09.servlet;

import chap09.entity.Our;
import chap09.entity.User;
import chap09.service.OurService;
import chap09.service.OurServicelmpl;
import chap09.service.UserService;
import chap09.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindUserById", urlPatterns = "/findUserById")
public class FindUserById extends HttpServlet {

    OurService ourService = new OurServicelmpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Our our = ourService.findUserById(id);
        request.setAttribute("our", our);
        request.getRequestDispatcher("updateUser.jsp").forward(request, response);
    }
}
