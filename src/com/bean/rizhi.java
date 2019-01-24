package com.bean;

public class rizhi {
    private   int id;
    private   String uname;
    private   String starttime;
    private   String endtime;
    private   String ipadress;

    public rizhi() {
    }

    public rizhi(int id, String uname, String starttime, String endtime, String ipadress) {
        this.id = id;
        this.uname = uname;
        this.starttime = starttime;
        this.endtime = endtime;
        this.ipadress = ipadress;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getIpadress() {
        return ipadress;
    }

    public void setIpadress(String ipadress) {
        this.ipadress = ipadress;
    }

    @Override
    public String toString() {
        return "rizhi{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", ipadress='" + ipadress + '\'' +
                '}';
    }
}
