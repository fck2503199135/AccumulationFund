package com.bean;

public class Post {
    //PID
    private  int pid;

    private  String pname;

    private  int did;

    private  String dname;

    private  String power;

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", did=" + did +
                ", dname=" + dname +
                '}';
    }

    public Post(int pid, String pname, int did, String dname,String power) {
        this.pid = pid;
        this.pname = pname;
        this.did = did;
        this.dname = dname;
        this.power=power;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Post(int pid, String pname, int did) {
        this.pid = pid;
        this.pname = pname;
        this.did = did;
    }

    public Post() {
    }

//    public Post(int pid, String pname) {
//        this.pid = pid;
//        this.pname = pname;
//    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}


