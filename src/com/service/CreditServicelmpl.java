package com.service;

import com.bean.Credit;
import com.dao.CreditDao;
import com.dao.CreditDaolmpl;

import java.util.List;

public class CreditServicelmpl implements CreditService {

    CreditDao cd = new CreditDaolmpl();
    @Override
    public void addCredit(Credit credit) {
        cd.addCredit(credit);
    }

    @Override
    public List<Credit> getAllCredit() {
        return cd.getAllCredit();
    }

    @Override
    public void goupdate(Credit credit) {
        cd.goupdate(credit);
    }

    @Override
    public void updatedeld(Credit credit) {
        cd.updatedeld(credit);
    }

    @Override
    public List<Credit> allDel() {
        return cd.allDel();
    }

    @Override
    public List<Credit> allGo() {
        return cd.allGo();
    }

    @Override
    public int del(int cid) {
        return cd.del(cid);
    }

    @Override
    public Credit getImg(int cid) {
        return cd.getImg(cid);
    }

    @Override
    public Credit getbyId(int cid) {
        return cd.getbyId(cid);
    }
}
