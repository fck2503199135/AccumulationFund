package com.bean;

public class Diary {
    private int did;
    private String dname;
    private String ddate;
    private String ip;
    private String dindex;
    private String mac;

    public Diary() {
    }

    public Diary(String dname, String ddate, String ip, String dindex, String mac) {
        this.dname = dname;
        this.ddate = ddate;
        this.ip = ip;
        this.dindex = dindex;
        this.mac = mac;
    }

    public String getDindex() {
        return dindex;
    }

    public void setDindex(String dindex) {
        this.dindex = dindex;
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

    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", ddate='" + ddate + '\'' +
                ", ip='" + ip + '\'' +
                ", dindex='" + dindex + '\'' +
                ", mac='" + mac + '\'' +
                '}';
    }
}
