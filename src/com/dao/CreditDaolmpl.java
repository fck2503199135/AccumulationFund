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
            qr.execute(con,"insert into credit values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",credit.getCdate(),credit.getIndex(),credit.getUname(),credit.getMymit(),credit.getCname(),credit.getCnum(),credit.getThmit(),credit.getWname(),credit.getWnum(),credit.getReason(),credit.getStyle(),credit.getImg(),credit.getDeld(),credit.getGoby());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(con);
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
            DB.close(con);
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
            DB.close(con);
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
            DB.close(con);
        }

    }


    @Override
    public List<Credit> allDel() {
        Connection con = DB.getcon();
        try {
            return qr.query(con,"select credit.*,uname from credit,user where credit.unid = user.uid and rid = 'R001'and deld = 1",new BeanListHandler<>(Credit.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(con);
        }
        return null;
    }

    @Override
    public List<Credit> allGo() {
        Connection con = DB.getcon();
        try {
            return qr.query(con,"select credit.*,uname from credit,user where credit.unid = user.uid and rid = 'R001' and goby = 0",new BeanListHandler<>(Credit.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(con);
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
            DB.close(con);
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
            DB.close(con);
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
            DB.close(con);
        }
        return null;
    }

    @Override
    public List<Credit> getCreditByIdName(String stime,String etime,String cname,String reason,String style) {
        Connection con = DB.getcon();

        try {
           return qr.query(con,"select credit.* , uname from credit,user where credit.unid = user.uid and cdate > ?  and cdate < ? and cname like ? and reason like ? and style like ? and deld is null and goby is null",new BeanListHandler<>(Credit.class),stime,etime,"%"+cname+"%","%"+reason+"%","%"+style+"%");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(con);
        }
        return null;
    }


    @Override
    public List<Credit> getDateName(String stime,String etime,String cname) {

        Connection con = DB.getcon();
        try {
            return qr.query(con, "SELECT reason,style,COUNT(*) AS count FROM (SELECT * FROM credit WHERE cdate > ?  AND  cdate < ? AND cname LIKE ? ) AS cre GROUP BY reason,style", new BeanListHandler<>(Credit.class),stime,etime,"%"+cname+"%");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(con);
        }
        return null;
    }

    @Override
    public List<Credit> getWork(String stime,String etime,String cname) {

        Connection con = DB.getcon();
        try {
            return qr.query(con, "SELECT uname,COUNT(*) AS count FROM user,(SELECT * FROM credit WHERE cdate > ?  AND  cdate < ? AND cname LIKE ? ) AS cre where cre.unid = user.uid and rid = 'R001' GROUP BY uname", new BeanListHandler<>(Credit.class),stime,etime,"%"+cname+"%");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(con);
        }
        return null;
    }

    //    @Override
//    public List<Credit> getAllcount(String se, String ee, String cnam,String count,String tse, String tee, String tcnam,String tcount) {
//
//        Connection con = DB.getcon();
//        try {
//           return qr.query(con,"SELECT * FROM credit WHERE reason in (SELECT reason FROM (SELECT reason,style,COUNT(*) AS count FROM (SELECT * FROM credit WHERE cdate > ?  AND cdate < ? AND cname LIKE ? ) AS cre GROUP BY reason,style ) AS ter WHERE ter.count = ?) and style in (SELECT style FROM (SELECT reason,style,COUNT(*) AS count FROM (SELECT * FROM credit WHERE cdate > ?  AND cdate < ? AND cname LIKE ? ) AS cre GROUP BY reason,style ) AS ter WHERE ter.count = ?) ", new BeanListHandler<>(Credit.class),se,ee,"%"+cnam+"%",count,tse,tee,"%"+tcnam+"%",tcount);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            DB.close(con);
//        }
//        return null;
//    }


    @Override
    public List<Credit> getAllcount(String reason, String style) {
        Connection con = DB.getcon();
        try {
            return qr.query(con, "SELECT credit.*,uname FROM credit,user where credit.unid = user.uid and rid = 'R001' and reason = ? and style = ?", new BeanListHandler<>(Credit.class),reason,style);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(con);
        }
        return null;
    }


    @Override
    public List<Credit> getAllwork(String uname) {
        Connection con = DB.getcon();
        try {
            return qr.query(con, "SELECT credit.*,uname FROM credit,user where credit.unid = user.uid and rid = 'R001' and uname = ?", new BeanListHandler<>(Credit.class),uname);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(con);
        }
        return null;
    }
}
