package chap09.dao;

import chap09.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findUsers();
    int insert(User user);
    User findUserById(int id);
    int update(User user);
    void deleteUserById(int id);
    void deleteUserByUsername(String username);
    List<User> findAllUsersPageable(int pageNow, int pageCount);
    int getTotalRow();

}
