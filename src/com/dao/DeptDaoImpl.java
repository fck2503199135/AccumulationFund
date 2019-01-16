package com.dao;

import com.bean.Dept;
import com.utils.DB;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    QueryRunner qr=new QueryRunner();
    @Override
    public void addDept(Dept dept) {
        Connection con = DB.getcon();
        try {
            qr.execute(con,"insert into Dept values(0,?)",dept.getDname());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close();
        }

    }

    @Override
    public List<Dept> getAllDept() {
        Connection con = DB.getcon();
        try {
            return   qr.query(con, "select * from dept", new BeanListHandler<>(Dept.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
