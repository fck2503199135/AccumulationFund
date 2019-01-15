package com.bean;

public class Identity {
    private int sid;
    private String sname;
    private String snum;

    public Identity() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", snum='" + snum + '\'' +
                '}';
    }
}
