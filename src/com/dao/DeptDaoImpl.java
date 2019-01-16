package com.dao;

import com.bean.Dept;
import com.utils.DB;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    QueryRunner qr=new QueryRunner();

    @Override
    public void delDept(int did) {
        Connection con = DB.getcon();
        try{
            qr.execute(con,"delete from Dept where did=?",did);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close();
        }

    }

    @Override
    public Dept getDeptByDid(int did) {
        Connection con = DB.getcon();

        try {
            return   qr.query(con, "select * from dept where did=?", new BeanHandler<>(Dept.class),did);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close();
        }

        return null;
    }

    @Override
    public void updateDept(Dept dept) {
        Connection con = DB.getcon();
        try {
            qr.execute(con,"update Dept set dname=? where did=?",dept.getDname(),dept.getDid());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close();
        }

    }

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
