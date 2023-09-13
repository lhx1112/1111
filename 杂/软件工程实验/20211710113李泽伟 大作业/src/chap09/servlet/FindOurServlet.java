package chap09.servlet;

import chap09.entity.Our;
import chap09.service.OurService;
import chap09.service.OurServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindOurServlet",urlPatterns = "/findOurServlet")
public class FindOurServlet extends HttpServlet {
    OurService ourService = new OurServicelmpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Our>ours=ourService.findAllUsers();
        int t =0;
        for (Our o :ours){
            if(o.getId()==id){
                t=1;
            }
        }
        if(t==1){
            Our our = ourService.findUserById(id);
            request.setAttribute("our", our);
            request.getRequestDispatcher("inquiry.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("findourNull.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
