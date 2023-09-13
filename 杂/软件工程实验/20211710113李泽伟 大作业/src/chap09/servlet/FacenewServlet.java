package chap09.servlet;

import chap09.entity.Email;
import chap09.entity.Our;
import chap09.entity.User;
import chap09.service.*;
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

@WebServlet(name = "FacenewServlet",urlPatterns = "/facenewServlet")
public class FacenewServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String username=(String)session.getAttribute("loginName");
        String face ="";
        int id=0;
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
                        // 文件
                        System.out.println("表单项name的值：" + fileItem.getFieldName());
                        System.out.println("上传文件名称：" + fileItem.getName());

                        //上传文件
                        face=fileItem.getName();
                        System.out.println(face);
                        File f = new File("../web/file/"+fileItem.getName());
                        if(f.exists()){
                            System.out.println("exist");
                        }
                        else{
                            fileItem.write(new File("../web/file/"+fileItem.getName()));
                            System.out.println("上传成功");
                        }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<User> userss = userService.findAllUsers();
        for (User users : userss) {
            if (users.getUsername().equals(username)) {
                 users.setFace(face);
                 userService.update(users);
            }
            break;
        }

        response.sendRedirect("faceSuc.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
