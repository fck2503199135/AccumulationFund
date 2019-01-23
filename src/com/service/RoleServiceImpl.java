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

    @Override
    public role getone(int id) {
        return rd.getone(id);
    }

    @Override
    public void update(role r1) {
      rd.update(r1);
    }

    @Override
    public void del(int id) {
        rd.del(id);
    }

    @Override
    public List<role> getone(String rid) {
        return rd.getone(rid);
    }


    public static void main(String[] args) {
       RoleService rs=new RoleServiceImpl();
              System.out.println(rs.getone("R003"));

    }
}
