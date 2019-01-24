package com.dao;


import com.bean.Member;
import com.utils.DB;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MemberDaoImpl implements MemberDao {
    
    QueryRunner qr=new QueryRunner();

    @Override
    public Member getMemberBymid(int mid) {

        Connection con = DB.getcon();

        try{
         return   qr.query(con,"select * from Member where Mid=?",new BeanHandler<>(Member.class),mid);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(con);
        }
         return null;
    }

    @Override
    public List<Member> getAllMember() {
        Connection con = DB.getcon();
        try {
            return   qr.query(con, "select mid,mname,post.pname,member.power,regtime from member,post where member.pid=post.pid", new BeanListHandler<>(Member.class));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }
        return null;
    }

    @Override
    public List<Member> getMemberByPid(int pid) {
        Connection con = DB.getcon();
        try {
            return   qr.query(con, "select * from member where pid=?", new BeanListHandler<>(Member.class),pid);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }

        return null;
    }

    /**
     * 修改
     * @param member
     */
    @Override
    public void updateMember(Member member) {
        Connection con = DB.getcon();

        try {
            qr.execute(con,"update Member set Mname=?,power=?,pid=? where Mid=?",member.getMname(),member.getPower(),member.getPid(),member.getMid());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }

    }

    @Override
    public void addMember(Member member) {
        Connection con = DB.getcon();
        try {
            qr.execute(con,"insert into Member values(0,?,?,?,?,?)",member.getMname(),member.getPower(),member.getPid(),member.getRegtime(),member.getRid());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }

    }

    @Override
    public void delMember(int mid) {
        Connection con = DB.getcon();

        try{
            qr.execute(con,"delete from Member where Mid=?",mid);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(con);
        }

    }
}
