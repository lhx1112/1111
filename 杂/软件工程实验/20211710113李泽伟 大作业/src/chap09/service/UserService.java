package chap09.service;

import chap09.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    int insert(User user);
    User findUserById(int id);
    int update(User user);
    void deleteUserById(int id);
    List<User> findAllUsersPageable(int pageNow, int pageCount);
    int getTotalUserCount();
    void deleteUserByUsername(String username);

}
