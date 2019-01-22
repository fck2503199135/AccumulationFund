package com.dao;
import com.bean.User;
import java.sql.Connection;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.utils.DB;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class UserDaoImpl implements UserDao {
        QueryRunner qr = new QueryRunner();

        @Override
        public User getUser(String name, String pwd) {
            Connection con = DB.getcon();
            try {
                return  qr.query(con,"select * from user where uname=? and upwd=?",new BeanHandler<>(User.class),name,pwd);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DB.close(con);
            }
            return null;
        }

    @Override
    public List<User> getAllusers() {
        Connection con = DB.getcon();
        try {
            return  qr.query(con,"select * from user ",new BeanListHandler<>(User.class));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }
        return null;
    }

    @Override
        public void updateStuNumber(User user) {
            Connection con = DB.getcon();
            try {
              qr.execute(con,"update user set unumber=? where uid=?",user.getUnumber(),user.getUid());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DB.close(con);
            }
        }

    @Override
    public void updateStuSTime(User user) {
            System.out.println(user.getLogintime());
             Connection con=DB.getcon();
             try{
                 qr.execute(con,"update user set logintime=? where uid=?",user.getLogintime(),user.getUid());
             }catch (Exception e){
                 e.printStackTrace();
             }finally {
                 DB.close(con);
             }
    }

    @Override
    public void updateStuETime(User user) {
        Connection con=DB.getcon();
        try{
            qr.execute(con,"update user set logouttime=? where uid=?",user.getLogouttime(),user.getUid());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DB.close(con);
        }
    }

    @Override
    public void updateStuPwd(User user){
        Connection con = DB.getcon();
        try {
           qr.execute(con,"update user set upwd=? where uid=?",user.getUpwd(),user.getUid());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }

    }

    public static void main(String[] args) {
//        UserDao u1=new UserDaoImpl();
//        List<User> users1=u1.getAllusers();
//            System.out.println(users1);
     }

    }




