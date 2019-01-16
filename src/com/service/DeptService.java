package com.service;

import com.bean.Dept;

import java.util.List;

public interface DeptService {

    public List<Dept> getAllDept();

    public void addDept(Dept dept);

    public Dept getDeptByDid(int did);

    /**
     * 删除
     */
    public void delDept(int did);
    /**
     * 修改
     */
    public void updateDept(Dept dept);
}
