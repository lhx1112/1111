package chap09.service;

import chap09.entity.Our;

import java.util.List;

public interface OurService {
    List<Our> findAllUsers();
    int insert(Our our);
    Our findUserById(int id);
    int update(Our our);
    void deleteUserById(int id);
    List<Our> findAllUsersPageable(int pageNow, int pageCount);
    int getTotalUserCount();

}
