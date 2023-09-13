package chap09.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import chap09.entity.Email;
import chap09.entity.Page;
import chap09.entity.User;
import chap09.service.EmailService;
import chap09.service.EmailServiceimpl;
import chap09.service.UserService;
import chap09.service.UserServiceImpl;

import java.util.List;

@WebServlet(name = "EmailFindAllPageableServlet2",urlPatterns = "/findEmailPageable2")
public class EmailFindAllPageableServlet2 extends HttpServlet {
    private EmailService emailService = new EmailServiceimpl();
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String receive_email=(String)session.getAttribute("loginemail");
        System.out.println(receive_email+"nihao");
        int pageNow = 1;
        if (request.getParameter("pageNow") != null){
            pageNow = Integer.parseInt(request.getParameter("pageNow"));
        }

        int pageCount = 10;

        int totalPage = 0;
        int totalRows = emailService.getTotalUserCount2(receive_email);

        if (totalRows % 10 == 0) {
            totalPage = totalRows / 10;
        }else {
            totalPage = totalRows / 10 + 1;
        }

        List<Email> emails = emailService.findAllUsersPageable2(receive_email,pageNow,pageCount);
        Page page = new Page(pageNow, pageCount, totalPage, totalRows);
        request.setAttribute("emails", emails);
        request.setAttribute("page", page);
        request.setAttribute("totalRows", totalRows);
        request.getRequestDispatcher("receive.jsp").forward(request, response);

    }
}
