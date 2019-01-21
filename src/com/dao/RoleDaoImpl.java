package com.dao;
import com.bean.User;
import com.bean.role;
import com.utils.DB;
import org.apache.commons.dbutils.QueryRunner;
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
            DB.close();
        }
        return null;
    }

    public static void main(String[] args) {
//        RoleDao rd=new RoleDaoImpl();
//        System.out.println(rd.getAllrole());
    }
}
