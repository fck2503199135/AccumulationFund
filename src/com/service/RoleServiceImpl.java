package com.service;

import com.bean.role;
import com.dao.RoleDao;
import com.dao.RoleDaoImpl;
import com.utils.DB;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    RoleDao rd=new RoleDaoImpl();
    @Override
    public List<role> getAllrole() {
        return rd.getAllrole();
    }

    public static void main(String[] args) {
//        RoleDao rd=new RoleDaoImpl();
//        System.out.println(rd.getAllrole());
    }
}
