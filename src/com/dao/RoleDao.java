package com.dao;

import com.bean.User;
import com.bean.role;

import java.util.List;

public interface RoleDao  {
    List<role> getAllrole();
    role getone(int id);
    void  update(role r1);
    void del(int id);
    List<role> getone(String rid);
}
