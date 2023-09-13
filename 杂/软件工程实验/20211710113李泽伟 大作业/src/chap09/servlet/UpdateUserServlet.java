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

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    OurService service = new OurServicelmpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String truename = request.getParameter("truename");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String postalcode = request.getParameter("postalcode");
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("loginName");

        int r = service.update(new Our(id, name, department,truename,email, phone,postalcode));
        if (r > 0){
                    response.sendRedirect("findUserPageable");
                }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
