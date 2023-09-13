package chap09.service;

import chap09.entity.Email;
import chap09.entity.Our;

import java.util.List;

public interface EmailService {
    List<Email> findAllUsers();
    int insert(Email email);
    Email findUserById(int id);
    int update(Email email);
    void deleteUserById(int id);
    List<Email> findAllUsersPageable(String username,int pageNow, int pageCount);
    List<Email> findAllUsersPageable2(String receive_email,int pageNow, int pageCount);
    int getTotalUserCount();
    int getTotalUserCount1(String username);
    int getTotalUserCount2(String receive_email);
}
