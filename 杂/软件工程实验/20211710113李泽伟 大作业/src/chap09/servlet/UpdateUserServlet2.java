package chap09.servlet;

import chap09.entity.Our;
import chap09.entity.User;
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

@WebServlet(name = "UpdateUserServlet2", urlPatterns = "/updateUser2")
public class UpdateUserServlet2 extends HttpServlet {

    UserService service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("loginName");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String postalcode = request.getParameter("postalcode");
        List<User> users = service.findAllUsers();
        for (User user : users){
            if(user.getUsername().equals(username)){
                int sex = user.getSex();
                String face = user.getFace();
                String password = user.getPassword();
                int r = service.update(new User(id, name, sex, phone,email,department,postalcode,password,username,face));
                if (r > 0){
                    response.sendRedirect("personServlet");
                }
                break;
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
