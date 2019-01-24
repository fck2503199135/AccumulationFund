package com.myservlet;
import com.alibaba.fastjson.JSON;
import com.bean.Dept;
import com.bean.Member;
import com.service.MemberService;
import com.service.MemberServiceImpl;
import com.utils.NowTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {

    MemberService ms=new MemberServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        System.out.println("-----servlet里");
        String type = request.getParameter("type");

        if (type.equals("getAll")) {
            List<Member> allMember = ms.getAllMember();
            System.out.println(allMember);
            response.getWriter().write(JSON.toJSONString(allMember));
        }else if (type.equals("add")){
            addMember(request,response);
        }else if (type.equals("edit")){
            edit(request,response);
        }else if (type.equals("update")){
            update(request,response);
         } else if (type.equals("del")) {
            del(request, response);
        }

    }

    private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("del方法里");
        int mid = Integer.parseInt(request.getParameter("mid"));
        ms.delMember(mid);
        response.getWriter().write(JSON.toJSONString(1));
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("edit方法里");
        int mid = Integer.parseInt(request.getParameter("mid"));
        Member memberBymid = ms.getMemberBymid(mid);
        System.out.println(memberBymid);
        response.getWriter().write(JSON.toJSONString(memberBymid));

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("update方法里+++++");

        String name = request.getParameter("name");

        String power = request.getParameter("power");

        int pid = Integer.parseInt(request.getParameter("pid"));

        int mid = Integer.parseInt(request.getParameter("mid"));

        System.out.println("update方法里+++++mid"+mid);
        String regtime= NowTime.ATime();
        String rid="1";
        Member member=new Member(mid,name,pid,regtime,rid);
        ms.updateMember(member);
        response.getWriter().write(JSON.toJSONString(1));

    }

    private void addMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("add方法里===================");

        String name = request.getParameter("name");

        System.out.println("name为"+name);



            String regtime= NowTime.ATime();
        System.out.println(regtime);

        String rid = request.getParameter("rid");

        System.out.println(rid+"=============");

        int pid = Integer.parseInt(request.getParameter("pid"));
        System.out.println("pid"+pid);
        Member member=new Member(0,name,pid,regtime,rid);
        ms.addMember(member);
        System.out.println("okkkkk");
        response.getWriter().write(JSON.toJSONString(1));

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
