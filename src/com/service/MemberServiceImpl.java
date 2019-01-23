package com.service;

import com.bean.Member;
import com.dao.MemberDao;
import com.dao.MemberDaoImpl;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    MemberDao md=new MemberDaoImpl();

    @Override
    public List<Member> getAllMember() {
        return md.getAllMember();
    }

    @Override
    public List<Member> getMemberByPid(int pid) {
        return md.getMemberByPid(pid);
    }

    @Override
    public void updateMember(Member member) {
        md.updateMember(member);
    }

    @Override
    public Member  getMemberBymid(int mid) {
     return  md.getMemberBymid(mid);
    }

    @Override
    public void addMember(Member member) {
        md.addMember(member);
    }

    @Override
    public void delMember(int mid) {
        md.delMember(mid);
    }
}
