package chap09.dao;

import chap09.entity.Notice;
import chap09.entity.User;

import java.util.List;

public interface NoticeDao {
    List<Notice> findNotices();
    List<Notice> findAllNoticesPageable(int pageNow, int pageCount);
    int getTotalRow();
}
