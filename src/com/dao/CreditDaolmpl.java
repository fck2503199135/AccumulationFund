package com.dao;

import com.bean.Credit;
import com.utils.DB;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CreditDaolmpl implements CreditDao {

    QueryRunner qr = new QueryRunner();
    @Override
    public void addCredit(Credit credit) {
        Connection con = DB.getcon();
        try {
            qr.execute(con,"insert into credit values(null,?,?,?,?,?,?,?,?,?)",credit.getCdate(),credit.getIndex(),credit.getCname(),credit.getCnum(),credit.getReason(),credit.getStyle(),credit.getImg(),credit.getDeld(),credit.getGoby());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close();
        }

    }


    @Override
    public List<Credit> getAllCredit() {
        Connection con = DB.getcon();
        try {
            return qr.query(con,"select * from credit where deld is null and goby is null",new BeanListHandler<>(Credit.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close();
        }

        return null;
    }

    @Override
    public void updatedeld(Credit credit) {
        Connection con = DB.getcon();
        try {
            qr.execute(con,"update credit set deld = ? where cid = ?",credit.getDeld(),credit.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close();
        }

    }

    @Override
    public void goupdate(Credit credit) {
        Connection con = DB.getcon();
        try {
            qr.execute(con,"update credit set goby = ? where cid = ?",credit.getGoby(),credit.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close();
        }

    }


    @Override
    public List<Credit> allDel() {
        Connection con = DB.getcon();
        try {
            return qr.query(con,"select * from credit where deld = 1",new BeanListHandler<>(Credit.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close();
        }
        return null;
    }

    @Override
    public List<Credit> allGo() {
        Connection con = DB.getcon();
        try {
            return qr.query(con,"select * from credit where goby = 0",new BeanListHandler<>(Credit.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close();
        }
        return null;
    }

    @Override
    public int del(int cid) {
        Connection con = DB.getcon();
        try {
            qr.execute(con,"delete from credit where cid = ?",cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close();
        }
        return 0;
    }

    @Override
    public Credit getImg(int cid) {
        Connection con = DB.getcon();
        try {
            return qr.query(con,"select img from credit where cid = ?",new BeanHandler<>(Credit.class),cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close();
        }

        return null;
    }

    @Override
    public Credit getbyId(int cid) {
        Connection con = DB.getcon();
        try {
            return qr.query(con,"select * from credit where cid = ?",new BeanHandler<>(Credit.class),cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close();
        }
        return null;
    }
}
