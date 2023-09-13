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
import chap09.service.EmailService;
import chap09.service.EmailServiceimpl;
import java.util.List;

@WebServlet(name = "EmailFindAllPageableServlet",urlPatterns = "/findEmailPageable")
public class EmailFindAllPageableServlet extends HttpServlet {
    private EmailService emailService = new EmailServiceimpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("loginName");
        int pageNow = 1;

        if (request.getParameter("pageNow") != null){
            pageNow = Integer.parseInt(request.getParameter("pageNow"));
        }

        int pageCount = 10;

        int totalPage = 0;
        int totalRows = emailService.getTotalUserCount1(username);

        if (totalRows % 10 == 0) {
            totalPage = totalRows / 10;
        }else {
            totalPage = totalRows / 10 + 1;
        }

        List<Email> emails = emailService.findAllUsersPageable(username,pageNow,pageCount);
        Page page = new Page(pageNow, pageCount, totalPage, totalRows);
        request.setAttribute("emails", emails);
        request.setAttribute("page", page);
        request.setAttribute("totalRows", totalRows);
        request.getRequestDispatcher("send.jsp").forward(request, response);

    }
}
