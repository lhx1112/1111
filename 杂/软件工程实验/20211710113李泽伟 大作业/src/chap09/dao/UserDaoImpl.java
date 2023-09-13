package chap09.dao;

import chap09.JDBCUtils;
import chap09.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findUsers() {
        List<User> users = new ArrayList<User>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from user";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                User user = new User(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)
                        ,rs.getString(10)
                );
                users.add(user);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int insert(User user) {

        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into user(name, sex, phone,email,department,postalcode,password,username,face) values(? ,? ,? ,?, ?, ?, ?, ?, ?)";
        int res = 0;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setInt(2, user.getSex());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getDepartment());
            pstmt.setString(6, user.getPostalcode());
            pstmt.setString(7, user.getPassword());
            pstmt.setString(8, user.getUsername());
            pstmt.setString(9,user.getFace());
            res = pstmt.executeUpdate();
            JDBCUtils.release(conn, pstmt, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public User findUserById(int id) {
       User user = null;
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from user where id = ?";
        PreparedStatement pstmt = null;
        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                user = new User(rs.getInt(1), rs.getString(2),rs.getInt(3),
                        rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7)
                        ,rs.getString(8),rs.getString(9) ,rs.getString(10)
                        );
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int update(User user) {
        int res = 0;
        Connection conn = JDBCUtils.getConnection();
        String sql = "update user set name = ?, sex = ?, phone = ?,email = ? ,department = ?,postalcode = ? ,password = ?, username=?,face = ? where id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setInt(2, user.getSex());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getDepartment());
            pstmt.setString(6, user.getPostalcode());
            pstmt.setString(7, user.getPassword());
            pstmt.setString(8, user.getUsername());
            pstmt.setString(9, user.getFace());
            pstmt.setInt(10, user.getId());
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
        String sql = "delete from user where id = ?";
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
    public void deleteUserByUsername(String username) {
        Connection conn = JDBCUtils.getConnection();
        String sql = "delete from user where username = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.executeUpdate();
            JDBCUtils.release(conn, pstmt, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAllUsersPageable(int pageNow, int pageCount) {
        List<User> users = new ArrayList<User>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from user limit ?, ?"; // 分页查询

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (pageNow-1)*pageCount); // 设定分页参数
            pstmt.setInt(2, pageCount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                User user = new User(rs.getInt(1), rs.getString(2),rs.getInt(3),
                        rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7)
                        ,rs.getString(8),rs.getString(9),rs.getString(10)
                        );
                users.add(user);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }



    @Override
    public int getTotalRow() {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select count(*) from user";
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
}
