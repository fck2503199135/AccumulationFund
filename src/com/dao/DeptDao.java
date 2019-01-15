package com.dao;

import com.bean.Dept;

import java.util.List;

public interface DeptDao {

    /**
     * 添加
     */
    public void addDept();

    /**
     * 查询全部
     */
    public List<Dept> getAllDept();
}
