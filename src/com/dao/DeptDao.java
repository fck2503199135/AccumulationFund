package com.dao;

import com.bean.Dept;

import java.util.List;

public interface DeptDao {

    /**
     * 添加
     */
    public void addDept(Dept dept);

    /**
     * 查询全部
     */
    public List<Dept> getAllDept();
    /**
     * 根据did查找dept
     */
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
