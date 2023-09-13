package chap09;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    //static 静态代码块，加载类的时候执行一次，仅 1 次
    static {
        try {
// 读取 db.properties 文件中的数据库连接信息
            InputStream in =
                    JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            System.out.println(in);
            Properties prop = new Properties();
            prop.load(in);
// 获取数据库连接驱动
            driver = prop.getProperty("driver");
// 获取数据库连接 URL 地址
            url = prop.getProperty("url");
// 获取数据库连接用户名
            username = prop.getProperty("username");
// 获取数据库连接密码
            password = prop.getProperty("password");
            System.out.println(driver + url);
// 加载数据库驱动
            Class.forName(driver);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
// 关闭存储查询结果的 ResultSet 对象
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {
// 关闭负责执行 SQL 命令的 Statement 对象
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
// 关闭 Connection 数据库连接对象
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
