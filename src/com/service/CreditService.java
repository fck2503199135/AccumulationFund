package com.service;

import com.bean.Credit;

import java.util.List;

public interface CreditService {
    void addCredit (Credit credit);
    List<Credit> getAllCredit();
    void goupdate(Credit credit);
    void updatedeld(Credit credit);
    List<Credit> allDel();
    List<Credit> allGo();
    int del (int cid);
    Credit getImg(int cid);
    Credit getbyId (int cid);

}
