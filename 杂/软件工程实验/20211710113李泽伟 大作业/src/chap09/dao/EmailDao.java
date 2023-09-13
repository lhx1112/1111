package chap09.dao;

import chap09.entity.Email;

import java.util.List;

public interface EmailDao {
    List<Email> findUsers();
    int insert(Email email);
    Email findUserById(int id);
    int update(Email email);
    void deleteUserById(int id);
    int getTotalRow1(String username);
    int getTotalRow2(String receive_email);
    List<Email> findAllUsersPageable(String username,int pageNow, int pageCount);
    List<Email> findAllUsersPageable2(String receive_email,int pageNow, int pageCount);
    int getTotalRow();
}
