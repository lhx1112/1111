package chap09.service;

import chap09.entity.Notice;
import chap09.entity.User;

import java.util.List;

public interface NoticeService {
    int getTotalNoticeCount();

    List<Notice> findAllNoticesPageable(int pageNow, int pageCount);

    List<Notice> findAllNotices();
}
