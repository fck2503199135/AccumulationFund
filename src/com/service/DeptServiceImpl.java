package com.service;

import com.bean.Dept;
import com.dao.DeptDao;
import com.dao.DeptDaoImpl;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    DeptDao dd=new DeptDaoImpl();

    @Override
    public List<Dept> getAllDept() {
        return dd.getAllDept();
    }
}
