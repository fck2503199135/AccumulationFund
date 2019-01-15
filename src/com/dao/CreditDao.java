package com.dao;

import com.bean.Credit;

import java.util.List;

public interface CreditDao {
    void addCredit (Credit credit);
    List<Credit> getAllCredit();
}
