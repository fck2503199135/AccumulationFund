package com.bean;

public class role {
    private  int id;
    private  String rid;
    private  String name;
    private  String jName;
    private  String jS;

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

    public String getJName() {
        return jName;
    }

    public void setJName(String jName) {
        this.jName = jName;
    }

    public String getjS() {
        return jS;
    }

    public void setJS(String jS) {
        this.jS = jS;
    }


    @Override
    public String toString() {
        return "role{" +
                "id=" + id +
                ", rid='" + rid + '\'' +
                ", name='" + name + '\'' +
                ", jName='" + jName + '\'' +
                ", jS='" + jS + '\'' +
                '}';
    }
}
