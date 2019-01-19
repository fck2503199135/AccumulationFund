package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    public static final String URL="jdbc:mysql://192.168.5.6:3306/secondteam?characterEncoding=utf8&useSSL=false&serverTimezone=GMT";
    public static final String USER="root";
    public static final String PAW="root";
    public static final String DRIVER= "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static Connection getcon(){

        try {
            Connection con = DriverManager.getConnection(URL, USER, PAW);
            return  con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection con){

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
