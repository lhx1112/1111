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

@WebServlet(name = "UserAddServlet",urlPatterns = "/addUser")
public class UserAddServlet extends HttpServlet {

    OurService service = new OurServicelmpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String postalcode = request.getParameter("postalcode");
        String username = request.getParameter("username");
        int r = service.insert(new Our(0, username, department,name,email,phone,postalcode));
        if (r > 0){
            response.sendRedirect("addUserSuc.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
