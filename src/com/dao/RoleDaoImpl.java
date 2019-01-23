package com.dao;
import com.bean.User;
import com.bean.role;
import com.utils.DB;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.Connection;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    QueryRunner qr=new QueryRunner();
    @Override
    public List<role> getAllrole() {
        Connection con = DB.getcon();
        try {
            return  qr.query(con,"select * from role ",new BeanListHandler<>(role.class));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }
        return null;
    }

    @Override
    public role getone(int id) {
        Connection con = DB.getcon();
        try {
            return  qr.query(con,"select * from role where id=?",new BeanHandler<>(role.class),id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }
        return null;
    }

    @Override
    public void update(role r1) {
        Connection conn= DB.getcon();
        try {
            qr.execute(conn,"update role set rid=?,name=?,jName=?,js=? where id=?",r1.getRid(),r1.getName(),r1.getJName(),r1.getjS(),r1.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(conn);
        }


    }

    @Override
    public void del(int id) {
        Connection conn= DB.getcon();
        try {
            qr.execute(conn,"delete from role where id=?",id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(conn);
        }
    }

    @Override
    public List<role> getone(String rid) {
        Connection con = DB.getcon();
        try {
            return  qr.query(con,"select * from role where rid=?",new BeanListHandler<>(role.class),rid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.close(con);
        }
        return null;
    }

    public static void main(String[] args) {
      RoleDao rd=new RoleDaoImpl();
      System.out.println(rd.getone("R001"));
    }
}
