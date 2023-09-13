package chap09.service;

import chap09.dao.UserDao;
import chap09.dao.UserDaoImpl;
import chap09.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAllUsers() {
        return userDao.findUsers();
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void deleteUserByUsername(String username) {
        userDao.deleteUserByUsername(username);
    }

    @Override
    public List<User> findAllUsersPageable(int pageNow, int pageCount) {
        return userDao.findAllUsersPageable(pageNow, pageCount);
    }

    @Override
    public int getTotalUserCount() {
        return userDao.getTotalRow();
    }
}
