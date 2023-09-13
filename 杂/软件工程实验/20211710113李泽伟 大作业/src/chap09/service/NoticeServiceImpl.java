package chap09.service;

import chap09.dao.*;
import chap09.entity.Notice;
import chap09.entity.User;

import java.util.List;

public class NoticeServiceImpl implements NoticeService{

    private NoticeDao noticeDao = new NoticeDaoImpl();


    @Override
    public List<Notice> findAllNoticesPageable(int pageNow, int pageCount) {
        return noticeDao.findAllNoticesPageable(pageNow, pageCount);
    }

    @Override
    public List<Notice> findAllNotices() {
        return noticeDao.findNotices();
    }

    @Override
    public int getTotalNoticeCount() {
        return noticeDao.getTotalRow();
    }
}
