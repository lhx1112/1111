package chap09.service;

import chap09.dao.EmailDao;
import chap09.dao.EmailDaoimpl;
import chap09.dao.OurDao;
import chap09.dao.OurDaolmpl;
import chap09.entity.Email;
import chap09.entity.Our;

import java.util.List;

public class EmailServiceimpl implements EmailService{
    private EmailDao emailDao = new EmailDaoimpl();

    @Override
    public List<Email> findAllUsers() {
        return emailDao.findUsers();
    }

    @Override
    public int insert(Email email) {
        return emailDao.insert(email);
    }

    @Override
    public Email findUserById(int id) {
        return emailDao.findUserById(id);
    }

    @Override
    public int update(Email email) {
        return emailDao.update(email);
    }

    @Override
    public void deleteUserById(int id) {
        emailDao.deleteUserById(id);
    }

    @Override
    public List<Email> findAllUsersPageable(String username,int pageNow, int pageCount) {
        return emailDao.findAllUsersPageable(username,pageNow, pageCount);
    }

    @Override
    public List<Email> findAllUsersPageable2(String receive_email,int pageNow, int pageCount) {
        return emailDao.findAllUsersPageable2(receive_email,pageNow, pageCount);
    }

    @Override
    public int getTotalUserCount() {
        return emailDao.getTotalRow();
    }

    @Override
    public int getTotalUserCount1(String username) {
        return emailDao.getTotalRow1(username);
    }

    @Override
    public int getTotalUserCount2(String receive_email) {
        return emailDao.getTotalRow2(receive_email);
    }
}
