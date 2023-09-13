package chap09.dao;

import chap09.entity.Our;

import java.util.List;

public interface OurDao {
    List<Our> findUsers();
    int insert(Our our);
    Our findUserById(int id);
    int update(Our our);
    void deleteUserById(int id);

    List<Our> findAllUsersPageable(int pageNow, int pageCount);
    int getTotalRow();
}
