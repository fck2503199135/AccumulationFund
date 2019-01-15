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
}
