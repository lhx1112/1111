package chap09.dao;

import chap09.JDBCUtils;
import chap09.entity.Our;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OurDaolmpl implements OurDao {

    @Override
    public List<Our> findUsers() {
        List<Our> ours = new ArrayList<Our>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from ourinfo";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Our our = new Our(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),rs.getString(5)
                        ,rs.getString(6),rs.getString(7)
                );
                ours.add(our);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ours;
    }

    @Override
    public int insert(Our our) {
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into ourinfo(username, department, truename,email,phone,postalcode) values(? ,? ,? ,?, ?, ?)";
        int res = 0;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, our.getUsername());
            pstmt.setString(2, our.getDepartment());
            pstmt.setString(3, our.getTruename());
            pstmt.setString(4, our.getEmail());
            pstmt.setString(5, our.getPhone());
            pstmt.setString(6, our.getPostalcode());
            res = pstmt.executeUpdate();
            JDBCUtils.release(conn, pstmt, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Our findUserById(int id) {
        Our our = null;
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from ourinfo where id = ?";
        PreparedStatement pstmt = null;
        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                our = new Our(rs.getInt(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7)
                );
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return our;
    }

    @Override
    public int update(Our our) {
        int res = 0;
        Connection conn = JDBCUtils.getConnection();
        String sql = "update ourinfo set username = ?, department = ?, truename = ?,email = ? ,phone = ?,postalcode = ?where id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, our.getUsername());
            pstmt.setString(2, our.getDepartment());
            pstmt.setString(3, our.getTruename());
            pstmt.setString(4, our.getEmail());
            pstmt.setString(5, our.getPhone());
            pstmt.setString(6, our.getPostalcode());
            pstmt.setInt(7, our.getId());
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
        String sql = "delete from ourinfo where id = ?";
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
    public List<Our> findAllUsersPageable(int pageNow, int pageCount) {
        List<Our> ours = new ArrayList<Our>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from ourinfo limit ?, ?"; // 分页查询

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (pageNow-1)*pageCount); // 设定分页参数
            pstmt.setInt(2, pageCount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Our our = new Our(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),rs.getString(5)
                        ,rs.getString(6), rs.getString(7)
                );
                ours.add(our);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ours;
    }

    @Override
    public int getTotalRow() {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select count(*) from ourinfo";
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
