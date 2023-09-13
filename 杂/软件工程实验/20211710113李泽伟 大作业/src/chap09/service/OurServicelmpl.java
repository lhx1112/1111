package chap09.service;

import chap09.dao.OurDao;
import chap09.dao.OurDaolmpl;
import chap09.entity.Our;
import java.util.List;
public class OurServicelmpl implements OurService{

    private OurDao ourDao = new OurDaolmpl();

    @Override
    public List<Our> findAllUsers() {
        return ourDao.findUsers();
    }

    @Override
    public int insert(Our our) {
        return ourDao.insert(our);
    }

    @Override
    public Our findUserById(int id) {
        return ourDao.findUserById(id);
    }

    @Override
    public int update(Our our) {
        return ourDao.update(our);
    }

    @Override
    public void deleteUserById(int id) {
        ourDao.deleteUserById(id);
    }

    @Override
    public List<Our> findAllUsersPageable(int pageNow, int pageCount) {
        return ourDao.findAllUsersPageable(pageNow, pageCount);
    }

    @Override
    public int getTotalUserCount() {
        return ourDao.getTotalRow();
    }
}
