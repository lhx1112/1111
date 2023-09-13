package chap09.servlet;

import chap09.entity.Email;
import chap09.entity.Notice;
import chap09.service.EmailService;
import chap09.service.EmailServiceimpl;
import chap09.service.NoticeService;
import chap09.service.NoticeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NoticedetailServlet",urlPatterns = "/noticedetail")
public class NoticedetailServlet extends HttpServlet {
    NoticeService noticeService=new NoticeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        request.setAttribute("content", content);
        //转发到目标页面，使得数据信息能在前端页面显示
        request.getRequestDispatcher("noticedetail.jsp").forward(request, response);
    }
}
