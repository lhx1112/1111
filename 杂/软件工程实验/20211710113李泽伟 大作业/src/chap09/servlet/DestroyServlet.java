package chap09.servlet;

import chap09.entity.Email;
import chap09.entity.Our;
import chap09.entity.User;
import chap09.service.EmailService;
import chap09.service.EmailServiceimpl;
import chap09.service.UserService;
import chap09.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DestroyServlet",urlPatterns = "/destroyServlet")
public class DestroyServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("loginName");
        userService.deleteUserByUsername(username);
        //转发到目标页面，使得数据信息能在前端页面显示
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}

