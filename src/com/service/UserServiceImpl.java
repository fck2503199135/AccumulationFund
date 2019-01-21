package com.service;

import com.bean.User;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.utils.DB;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class UserServiceImpl implements UserService{
        UserDao ud=new UserDaoImpl();

        @Override
        public void updateStuNumber(User user) {

            ud.updateStuNumber(user);
        }

    @Override
    public void updateStuPwd(User user) {
           ud.updateStuPwd(user);
    }

    @Override
    public void updateStuSTime(User user) {
        ud.updateStuSTime(user);
    }

    @Override
    public void updateStuETime(User user) {
            ud.updateStuETime(user);
    }


    @Override
        public User getUser(String name, String pwd) {
            return ud.getUser(name,pwd);
        }

    @Override
    public List<User> getAllusers() {
        return ud.getAllusers();
    }


    public static void main(String[] args) {
//        UserService us=new UserServiceImpl();
//        System.out.println(us.getAllusers());
    }
}
