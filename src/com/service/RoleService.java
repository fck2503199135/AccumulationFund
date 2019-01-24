package com.service;

import com.bean.role;

import java.util.List;

public interface RoleService {
    List<role> getAllrole();
    role getone(int id);
    void  update(role r1);
    void del(int id);
    List<role> getone(String rid);
}
