package com.bean;

import java.util.Date;

public class Member {
    public Member() {
    }

    private  int mid;       //成员id
    private  String mname; //成员名称
    private  String power;//权限

    private  int pid;//所属岗位id

                          //岗位名称
    private  String pname;

    private  int checked;//是否选中

    public Member(int mid, String mname, int pid, String regtime) {
        this.mid = mid;
        this.mname = mname;
        this.pid = pid;
        this.regtime = regtime;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", power='" + power + '\'' +
                ", pid=" + pid +
                ", pname='" + pname + '\'' +
                ", regtime='" + regtime + '\'' +
                '}';
    }

    public Member(int mid, String mname, String power, int pid, String regtime) {
        this.mid = mid;
        this.mname = mname;
        this.power = power;
        this.pid = pid;
        this.regtime = regtime;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    //注册时间
    private  String regtime;

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }










    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
