package com.bean;

public class Post {
    //PID
    private  int pid;

    private  String pname;

    private  int did;

    private  int dname;

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", did=" + did +
                ", dname=" + dname +
                '}';
    }

    public Post(int pid, String pname, int did, int dname) {
        this.pid = pid;
        this.pname = pname;
        this.did = did;
        this.dname = dname;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getDname() {
        return dname;
    }

    public void setDname(int dname) {
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


