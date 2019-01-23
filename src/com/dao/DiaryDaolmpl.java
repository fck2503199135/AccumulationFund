package com.dao;


import com.bean.Diary;
import com.utils.DB;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DiaryDaolmpl implements DiaryDao {
    QueryRunner qr = new QueryRunner();
    @Override
    public void addDiary(Diary diary) {
        Connection con = DB.getcon();
        try {
            qr.execute(con,"insert into diary values(null,?,?,?,?,?)",diary.getDdate(),diary.getDname(),diary.getIp(),diary.getDindex(),diary.getMac());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(con);
        }
    }


    @Override
    public List<Diary> getAllDiary() {
        Connection con = DB.getcon();
        try {
            return qr.query(con,"select * from diary",new BeanListHandler<>(Diary.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(con);
        }
        return null;
    }
}
