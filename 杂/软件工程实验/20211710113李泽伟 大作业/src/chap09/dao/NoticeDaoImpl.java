package chap09.dao;

import chap09.JDBCUtils;
import chap09.entity.Notice;
import chap09.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeDaoImpl implements NoticeDao{

    @Override
    public List<Notice> findNotices() {
        List<Notice> notices = new ArrayList<Notice>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from notice";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Notice notice = new Notice(rs.getInt(1), rs.getString(2),
                        rs.getDate(3), rs.getString(4)
                );
                notices.add(notice);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notices;
    }


    @Override
    public List<Notice> findAllNoticesPageable(int pageNow, int pageCount) {
        List<Notice> notices = new ArrayList<Notice>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select * from notice limit ?, ?"; // 分页查询

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (pageNow-1)*pageCount); // 设定分页参数
            pstmt.setInt(2, pageCount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Notice notice = new Notice(rs.getInt(1), rs.getString(2),rs.getDate(3),
                        rs.getString(4)
                );
                notices.add(notice);
            }
            JDBCUtils.release(conn, pstmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notices;
    }



    @Override
    public int getTotalRow() {
        Connection conn = JDBCUtils.getConnection();
        String sql = "select count(*) from notice";
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
