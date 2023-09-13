package chap09.servlet;
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

@WebServlet(name = "PersonServlet",urlPatterns = "/personServlet")
public class PersonServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = userService.findAllUsers();
        //将数据库获取的数据保存到 request 范围内
        request.setAttribute("users", users);
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("loginName");
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                User u = user;
                String url = "/images/" + u.getFace();
                session.setAttribute("url", url);
                break;
            }
        }

        //转发到目标页面，使得数据信息能在前端页面显示
        request.getRequestDispatcher("personinfo.jsp").forward(request, response);
    }
}
