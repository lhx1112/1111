package chap09.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "Filter" ,urlPatterns = "/*")
public class Filter2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//从session页面获取用户的
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        //这里对于一些特殊的就不需要拦截
        String requestURI = req.getRequestURI();
        String[] resources = {"css","images","login.jsp","register.jsp","checkCodeServlet","loginServlet","registerServlet","AddressServlet"};
        for (String resource : resources) {
            if (requestURI.contains(resource)) {
                //内容包含这些就放行，并且结束
                chain.doFilter(request, response);
                return;
            }
        }
        //通过LoginServlet中设置的session的名字获取用户名
        Object username = session.getAttribute("username");
        //判断用户名是否存在（存在说明登录成功，并且将用户传到session上了）
        if (username == null) {
//            req.setAttribute("loginMessage","请先登录");
            req.getRequestDispatcher("login.jsp").forward(request,response);
        }else {
            //放行登录
            chain.doFilter(request, response);
        }

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println(222);
    }

}
