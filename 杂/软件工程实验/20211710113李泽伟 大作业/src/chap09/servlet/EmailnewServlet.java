package chap09.servlet;

import chap09.entity.Email;
import chap09.entity.Our;
import chap09.service.EmailService;
import chap09.service.EmailServiceimpl;
import chap09.service.EmailServiceimpl;
import chap09.service.OurService;
import chap09.service.OurServicelmpl;
import chap09.service.OurService;
import chap09.service.OurServicelmpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmailnewServlet",urlPatterns = "/sendEmailServlet")
public class EmailnewServlet extends HttpServlet {
    private EmailService emailService = new EmailServiceimpl();
    private OurService ourService = new OurServicelmpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("loginName");
        System.out.println(username);
        String title="";
        String content="";
        String attachment="";
        String receive_email="";
        if(ServletFileUpload.isMultipartContent(request)) {
            //创建 FileItemFactory 工厂实现类

            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建用于解析上传数据的工具类 ServletFileUpload 类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                // 解析上传的数据，得到每一个表单项 FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //循环判断，每一个表单项，是普通类型，还是上传的文件
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        switch (fileItem.getFieldName()) {
                            case "title":
                                title = fileItem.getString("UTF-8");
                                System.out.println(title);
                                break;
                            case "content":
                                content = fileItem.getString("UTF-8");
                                System.out.println(content);
                                break;
                            case "receive_email":
                                receive_email = fileItem.getString("UTF-8");
                                System.out.println(receive_email);
                                break;
                        }
                    }else{
                        // 文件
                        System.out.println("表单项name的值：" + fileItem.getFieldName());
                        System.out.println("上传文件名称：" + fileItem.getName());

                        //上传文件
                        attachment=fileItem.getName();
                        System.out.println(attachment);
                        File f = new File("../web/file/"+fileItem.getName());
                        if(f.exists()){
                            System.out.println("exist");
                        }
                        else{
                            fileItem.write(new File("../web/file/"+fileItem.getName()));
                            System.out.println("上传成功");
                        }

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(content);
        String send_email="";
        List<Our> ourss = ourService.findAllUsers();
        for (Our ours : ourss) {
            if (ours.getUsername().equals(username)) {
                send_email=ours.getEmail();
            }
        }

        emailService.insert(new Email(0, send_email,receive_email,title,content,attachment,username));

        response.sendRedirect("sendEmailSuc.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
