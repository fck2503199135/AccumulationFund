package com.service;

import com.bean.Member;

import java.util.List;

public interface MemberService {

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

    /**
     * 编辑根据mid查找
     */
    public  Member  getMemberBymid(int mid);
}
