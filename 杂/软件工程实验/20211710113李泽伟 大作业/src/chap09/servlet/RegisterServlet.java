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

@WebServlet(name = "RegisterServlet",urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决请求中文乱码
        request.setCharacterEncoding("utf-8");
        // 获取表单参数

        String user = request.getParameter("user");
        int sex = request.getIntHeader("sex");
        String pwd = request.getParameter("pwd");
        String truename = request.getParameter("truename");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String postalcode = request.getParameter("postalcode");
        String re = request.getParameter("re");
        HttpSession session = request.getSession();
        List<User> users = userService.findAllUsers();
        String usernamecheck = "";
        for (User user1 : users) {
            if (user1.getUsername().equals(user)) {
                usernamecheck = user1.getUsername();
            }
        }
        int ch = 0;
        for (int i = 0; i < phone.length(); i++) {
            if (phone.charAt(i) == ' ' || (phone.charAt(i) >= 97 &&
                    phone.charAt(i) <= 122) || (phone.charAt(i) >= 65 && phone.charAt(i) <= 90)) {
                ch = 1;
            }
        }
        String face = "1.jpg";
        String department = "实习部";
        if (phone.length() != 11 || ch == 1) {
            session.setAttribute("registerError", "手机号码输入有误！！！");
            response.sendRedirect("register.jsp");
        }
        else if(pwd.length()<6 || pwd.length()>12)
        {
            session.setAttribute("registerError", "密码格式不正确！！！");
            response.sendRedirect("register.jsp");
        }
        else {
            if (usernamecheck == "") {
                System.out.println("583725734");
                userService.insert(new User(0, truename, sex, phone, email, department, postalcode, pwd, user, face));
                session.setAttribute("loginName", user);
                response.sendRedirect("main.jsp");
            } else {
                session.setAttribute("registerError", "该用户名已经被注册！！！");
                response.sendRedirect("register.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
