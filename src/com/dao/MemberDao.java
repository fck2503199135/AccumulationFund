package com.dao;

import com.bean.Member;

import java.util.List;

public interface MemberDao {


    public List<Member> getAllMember();

    /**
     *根据岗位pid查询
     */
    public List<Member> getMemberByPid(int pid);

    /**
     * 添加
     */
    public void addMember(Member member);

    /**
     * 删除 根据mid
     */
    public  void  delMember(int mid);

    /**
     * 修改
     */
    public void updateMember(Member member);
}
