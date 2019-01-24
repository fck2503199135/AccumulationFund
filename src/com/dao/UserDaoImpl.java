package com.dao;
import com.bean.User;
import java.sql.Connection;
import java.util.List;

import com.bean.rizhi;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.utils.DB;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class UserDaoImpl implements UserDao {
        QueryRunner qr = new QueryRunner();

        @Override
        public User getUser(String name, String pwd) {
            Connection con = DB.getcon();
            System.out.println(con);
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
    public rizhi getRizhi() {
        Connection con = DB.getcon();
        System.out.println(con);
        try {
            return  qr.query(con," select * from rizhi order by uid desc LIMIT 1",new BeanHandler<>(rizhi.class));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }
        return null;
    }

    @Override
    public void updaterizhis(rizhi rz) {
        Connection con = DB.getcon();
        try {
            qr.execute(con,"insert into rizhi(starttime,ipaddress,uname) values(?,?,?)",rz.getStarttime(),rz.getIpaddress(),rz.getUname());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }
    }

    @Override
    public void updaterizhie(rizhi rz) {
        Connection con = DB.getcon();
        try {
            qr.execute(con,"update rizhi set endtime=? where uid=?",rz.getEndtime(),rz.getUid());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }
    }

    @Override
    public List<rizhi> getAllrizhis(String uname) {
        Connection con = DB.getcon();
        try {
        return  qr.query(con,"select * from rizhi where uname=?",new BeanListHandler<>(rizhi.class),uname);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }
        return null;
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
//       UserDao u1=new UserDaoImpl();
//        List<rizhi> users1=u1.getAllrizhis("b2");
//         System.out.println(users1);
     }

    }




