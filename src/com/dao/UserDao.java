package com.dao;

import com.bean.User;
import com.bean.rizhi;

import java.util.List;

public interface UserDao {
    User getUser(String name, String pwd);
    List<User> getAllusers();
    void updateStuPwd(User user);
    void updateStuNumber(User user);
    rizhi getRizhi();
    void updaterizhis(rizhi rz);
    void updaterizhie(rizhi rz);
    List<rizhi> getAllrizhis(String uname);
}
