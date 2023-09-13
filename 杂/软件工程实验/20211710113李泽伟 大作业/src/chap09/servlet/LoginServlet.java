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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usernamecheck="";
        String passwordcheck="";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String check=request.getParameter("check");
        String sec_check=(String)request.getSession().getAttribute("sd_check");
        HttpSession session = request.getSession();
        List<User> users = userService.findAllUsers();

        for (User user : users){
            if(user.getUsername().equals(username)){
                usernamecheck=user.getUsername();
                passwordcheck=user.getPassword();
            }
        }
        if(usernamecheck==""){
            session.setAttribute("loginError", "找不到此用户！！！");
            response.sendRedirect("login.jsp");
        }else{
            //判断用户名密码是否正确
            if (passwordcheck.equals(password)) {
                if (check.equals(sec_check)){
                    session.setAttribute("loginName", username);
                    response.sendRedirect("main.jsp");
                    session.setAttribute("username", username);
                }
                else {
                    session.setAttribute("loginError", "验证码错误！！！");
                    response.sendRedirect("login.jsp");
                }
            }else {
                session.setAttribute("loginError", "密码错误！！！");
                response.sendRedirect("login.jsp");
            }
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
