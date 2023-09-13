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
import java.util.List;

@WebServlet(name = "UserFindAllServlet", urlPatterns = "/findAllUsers")
public class UserFindAllServlet extends HttpServlet {


    private OurService ourService = new OurServicelmpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Our> ours = ourService.findAllUsers();
        //将数据库获取的数据保存到 request 范围内
        request.setAttribute("ours", ours);
        //转发到目标页面，使得数据信息能在前端页面显示
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}
