package com.service;

import com.bean.Dept;
import com.dao.DeptDao;
import com.dao.DeptDaoImpl;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    DeptDao dd=new DeptDaoImpl();

    @Override
    public void updateDept(Dept dept) {
        dd.updateDept(dept);
    }

    @Override
    public void delDept(int did) {
        dd.delDept(did);
    }

    @Override
    public List<Dept> getAllDept() {
        return dd.getAllDept();
    }

    @Override
    public void addDept(Dept dept) {
        dd.addDept(dept);
    }

    @Override
    public Dept getDeptByDid(int did) {
        return dd.getDeptByDid(did);
    }
}
