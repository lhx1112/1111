package chap09.servlet;

import chap09.entity.Notice;
import chap09.entity.Our;
import chap09.entity.Page;
import chap09.service.NoticeService;
import chap09.service.NoticeServiceImpl;
import chap09.service.OurService;
import chap09.service.OurServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NoticeFindAllPageableServlet",urlPatterns = "/findNoticePageable")
public class NoticeFindAllPageableServlet extends HttpServlet {

    private NoticeService noticeService = new NoticeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNow = 1;

        if (request.getParameter("pageNow") != null){
            pageNow = Integer.parseInt(request.getParameter("pageNow"));
        }

        int pageCount = 10;
        int totalPage = 0;
        int totalRows = noticeService.getTotalNoticeCount();

        if (totalRows % 10 == 0) {
            totalPage = totalRows / 10;
        }else {
            totalPage = totalRows / 10 + 1;
        }

        List<Notice> notices = noticeService.findAllNoticesPageable(pageNow,pageCount);
        Page page = new Page(pageNow, pageCount, totalPage, totalRows);
        request.setAttribute("notices", notices);
        request.setAttribute("page", page);
        request.setAttribute("totalRows", totalRows);
        request.getRequestDispatcher("notice.jsp").forward(request, response);
    }
}
