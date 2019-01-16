package com.service;

import com.bean.Dept;

import java.util.List;

public interface DeptService {

    public List<Dept> getAllDept();

    public void addDept(Dept dept);
}
