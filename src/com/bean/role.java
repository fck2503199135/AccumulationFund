package com.bean;

public class role {
    private  int id;
    private  String rid;
    private  String name;
    private  String Jname;
    private  String JS;

    public role() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJname() {
        return Jname;
    }

    public void setJname(String jname) {
        Jname = jname;
    }

    public String getJS() {
        return JS;
    }

    public void setJS(String JS) {
        this.JS = JS;
    }


    @Override
    public String toString() {
        return "role{" +
                "id=" + id +
                ", rid='" + rid + '\'' +
                ", name='" + name + '\'' +
                ", Jname='" + Jname + '\'' +
                ", JS='" + JS + '\'' +
                '}';
    }
}
