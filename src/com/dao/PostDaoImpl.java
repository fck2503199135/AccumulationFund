package com.dao;

import com.bean.Dept;
import com.bean.Post;
import com.utils.DB;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PostDaoImpl implements PostDao {

    QueryRunner qr=new QueryRunner();

    @Override
    public void addPost(Post post) {

        Connection con = DB.getcon();
        try {
            qr.execute(con,"insert into Post values(0,?,?)",post.getPname(),post.getDid());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }

    }

    @Override
    public List<Post> getAllPost() {

        Connection con = DB.getcon();
        try {
            return   qr.query(con, "select pid,pname,dept.dname,power from post,dept where post.did=dept.did",new BeanListHandler<>(Post.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(con);
        }
        return null;
    }

    @Override
    public Post getPostByPid(int pid) {

        Connection con = DB.getcon();

        try {
            return   qr.query(con, "select * from Post where pid=?", new BeanHandler<>(Post.class),pid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }

        return null;
    }

    @Override
    public void delPost(int pid) {
        Connection con = DB.getcon();
        try{
            qr.execute(con,"delete from Post where pid=?",pid);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(con);
        }
    }

    @Override
    public void updatePost(Post post) {
        Connection con = DB.getcon();

        try {
            qr.execute(con,"update Post set pname=?,did=? where pid=?",post.getPname(),post.getDid(),post.getPid());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }

    }

    @Override
    public List<Post> getPostByNameAndDid(String name, int did) {
        Connection con = DB.getcon();

        try {
            if(did==0){

                return   qr.query(con, "select pid,pname,dept.dname,power from post,dept where post.did=dept.did and pname like ?", new BeanListHandler<>(Post.class),"%"+name+"%");


            }else {

                return   qr.query(con, "select pid,pname,dept.dname,power from post,dept where post.did=dept.did and dept.did=? and pname like ?", new BeanListHandler<>(Post.class),did,"%"+name+"%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DB.close(con);
        }


        return null;
    }
}
