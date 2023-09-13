package chap09.servlet;

import chap09.entity.Email;
import chap09.service.EmailService;
import chap09.service.EmailServiceimpl;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet(name = "FiledownloadServlet",urlPatterns = "/filedownload")
public class FiledownloadServlet extends HttpServlet {
    EmailService emailService=new EmailServiceimpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Email email=emailService.findUserById(id);
        //2、下载文件的文件名？
        String fileName = email.getAttachment();
        System.out.println(fileName);
        //1、获得下载文件的路径
        String realPath = "D:\\python\\file" + fileName;
        System.out.println(realPath);
        //3、设置type，让浏览器支持下载
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
        //4、获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //5、创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //6、获取OutputStream对象
        ServletOutputStream out = response.getOutputStream();
        //7、将FileOutputStream流写入buffer缓冲区
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
//        response.sendRedirect("sendEmailSuc.jsp");
    }
}
