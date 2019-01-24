package com.service;

import com.bean.User;
import com.bean.rizhi;

import java.util.List;

public interface UserService {
    User getUser(String name, String pwd);
    List<User> getAllusers();
    void updateStuNumber(User user);
    void updateStuPwd(User user);
    void updaterizhis(rizhi rz);
    void updaterizhie(rizhi rz);
    rizhi getRizhi();
    List<rizhi> getAllrizhis(String uname);

}
