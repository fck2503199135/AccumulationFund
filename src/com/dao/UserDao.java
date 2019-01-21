package com.dao;

import com.bean.User;

import java.util.List;

public interface UserDao {
    User getUser(String name, String pwd);
    List<User> getAllusers();
    void updateStuPwd(User user);
    void updateStuNumber(User user);
    void updateStuSTime(User user);
    void updateStuETime(User user);
}
