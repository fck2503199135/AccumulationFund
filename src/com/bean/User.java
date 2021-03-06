package com.bean;

public class User {
    private int uid;
    private String uname;
    private String upwd;
    private int unumber;
    private  String  realname;

    public User(int uid, String uname, String upwd,  int unumber, String realname) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.unumber = unumber;
        this.realname = realname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public User() {
    }

    public User(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public User(int uid, String uname, String upwd, int unumber) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.unumber = unumber;
    }

    public User(int uid, String uname, String upwd, String logintime, String logouttime, int unumber) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;

        this.unumber = unumber;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public int getUnumber() {
        return unumber;
    }

    public void setUnumber(int unumber) {
        this.unumber = unumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", unumber=" + unumber +
                '}';
    }

}
