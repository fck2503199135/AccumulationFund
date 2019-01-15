package com.service;

import com.bean.Credit;

import java.util.List;

public interface CreditService {
    void addCredit (Credit credit);
    List<Credit> getAllCredit();

}
