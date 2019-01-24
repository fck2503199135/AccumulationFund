package com.bean;

public class rizhi {
    private   int uid;
    private   String uname;
    private   String starttime;
    private   String endtime;
    private   String ipaddress;


    public rizhi() {
    }

    public rizhi( String uname, String starttime, String ipaddress) {
        this.uname = uname;
        this.starttime = starttime;
        this.ipaddress = ipaddress;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
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


    @Override
    public String toString() {
        return "rizhi{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                '}';
    }



}
