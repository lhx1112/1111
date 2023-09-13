package chap09.dao;

import chap09.JDBCUtils;
import chap09.entity.Email;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmailDaoimpl implements EmailDao {
    @Override
    public List<Email> findUsers() {
        List<Email> emails = new ArrayList<Email>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from emailinfo";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Email email = new Email(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getString(7)
                );
                emails.add(email);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emails;
    }


    @Override
    public int insert(Email email) {
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into emailinfo(send_email, receive_email,title,content,attachment,username) values(? ,? ,?, ?, ?, ?)";
        int res = 0;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email.getSend_email());
            pstmt.setString(2, email.getReceive_email());
            pstmt.setString(3, email.getTitle());
            pstmt.setString(4, email.getContent());
            pstmt.setString(5, email.getAttachment());
            pstmt.setString(6, email.getUsername());
            res = pstmt.executeUpdate();
            JDBCUtils.release(conn, pstmt, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Email findUserById(int id) {
        Email email = null;
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from emailinfo where id = ?";
        PreparedStatement pstmt = null;
        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                email = new Email(rs.getInt(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)
                );
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    @Override
    public int update(Email email) {
        int res = 0;
        Connection conn = JDBCUtils.getConnection();
        String sql = "update emailinfo set send_email = ?, receive_email = ?,title = ? ,content = ?,attachment = ? username = ?where id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email.getSend_email());
            pstmt.setString(2, email.getReceive_email());
            pstmt.setString(3, email.getTitle());
            pstmt.setString(4, email.getContent());
            pstmt.setString(5, email.getAttachment());
            pstmt.setString(6, email.getUsername());
            pstmt.setInt(7, email.getId());
            res = pstmt.executeUpdate();
            JDBCUtils.release(conn, pstmt, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }


    @Override
    public void deleteUserById(int id) {
        Connection conn = JDBCUtils.getConnection();
        String sql = "delete from emailinfo where id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JDBCUtils.release(conn, pstmt, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Email> findAllUsersPageable(String username,int pageNow, int pageCount) {
        List<Email> emails = new ArrayList<Email>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from emailinfo where username =? limit ?, ?"; // 分页查询

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setInt(2, (pageNow-1)*pageCount); // 设定分页参数
            pstmt.setInt(3, pageCount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Email email = new Email(rs.getInt(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7)
                );
                emails.add(email);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emails;
    }

    @Override
    public List<Email> findAllUsersPageable2(String receive_email,int pageNow, int pageCount) {
        List<Email> emails = new ArrayList<Email>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from emailinfo where receive_email = ? limit ?, ?"; // 分页查询

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,receive_email);
            pstmt.setInt(2, (pageNow-1)*pageCount); // 设定分页参数
            pstmt.setInt(3, pageCount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Email email = new Email(rs.getInt(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7)
                );
                emails.add(email);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emails;
    }

    @Override
    public int getTotalRow() {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select count(*) from emailinfo";
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int getTotalRow1(String username) {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select count(*) from emailinfo where username=?";
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int getTotalRow2(String receive_email) {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select count(*) from emailinfo where receive_email=?";
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,receive_email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
