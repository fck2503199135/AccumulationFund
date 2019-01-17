package com.dao;

import com.bean.Credit;

import java.util.List;

public interface CreditDao {
    void addCredit (Credit credit);
    List<Credit> getAllCredit();
    void updatedeld(Credit credit);
    void goupdate(Credit credit);
    List<Credit> allDel();
    List<Credit> allGo();
    int del (int cid);
    Credit getImg(int cid);
    Credit getbyId (int cid);
    List<Credit> getCreditByIdName(String stime,String etime,String cname,String reason,String style);
}
