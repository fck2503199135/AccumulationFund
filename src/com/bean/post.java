package com.bean;

public class post {

    private int pid;
    private  String pname;

    public post() {
    }

    public post(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

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

    @Override
    public String toString() {
        return "post{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                '}';
    }
}
