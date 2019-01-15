package com.dao;

import com.bean.Credit;
import com.utils.DB;
import org.apache.commons.dbutils.QueryRunner;
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
            qr.execute(con,"insert into credit values(null,?,?,?,?,?)",credit.getCname(),credit.getCnum(),credit.getReason(),credit.getStyle(),credit.getImg());
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
            return qr.query(con,"select * from credit",new BeanListHandler<>(Credit.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close();
        }

        return null;
    }
}
