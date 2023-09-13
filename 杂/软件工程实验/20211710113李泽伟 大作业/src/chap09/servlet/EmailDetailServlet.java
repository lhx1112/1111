package chap09.servlet;

import chap09.entity.Email;
import chap09.entity.User;
import chap09.service.EmailService;
import chap09.service.EmailServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmailDetailServlet",urlPatterns = "/emaildetail")
public class EmailDetailServlet extends HttpServlet {
    EmailService emailService=new EmailServiceimpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Email emailss = emailService.findUserById(id);
                request.setAttribute("emails", emailss);
                //转发到目标页面，使得数据信息能在前端页面显示
                request.getRequestDispatcher("emaildetail.jsp").forward(request, response);
        }
    }
