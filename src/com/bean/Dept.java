package com.bean;

public class Dept {

          private int did;

          private String dname;

          private String daddress;

    public Dept(int did, String dname, String daddress) {
        this.did = did;
        this.dname = dname;
        this.daddress = daddress;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", daddress='" + daddress + '\'' +
                '}';
    }

    public String getDaddress() {
        return daddress;
    }

    public void setDaddress(String daddress) {
        this.daddress = daddress;
    }

    public Dept() {
    }

    public Dept(int did, String dname) {
        this.did = did;
        this.dname = dname;
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
}
