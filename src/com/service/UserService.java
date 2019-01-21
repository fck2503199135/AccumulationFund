package com.service;

import com.bean.User;

import java.util.List;

public interface UserService {
    User getUser(String name, String pwd);
    List<User> getAllusers();
    void updateStuNumber(User user);
    void updateStuPwd(User user);
    void updateStuSTime(User user);
    void updateStuETime(User user);

}
