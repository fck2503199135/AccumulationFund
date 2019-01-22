package com.myservlet;
import com.alibaba.fastjson.JSON;
import com.bean.MD5JM;

import com.bean.User;
import com.bean.role;
import com.service.RoleService;
import com.service.RoleServiceImpl;
import com.service.UserService;
import com.service.UserServiceImpl;
import com.utils.DB;
import com.utils.NowTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet("/newLoginservlet")
public class newLoginservlet extends HttpServlet {
    UserService us = new UserServiceImpl();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String type=req.getParameter("type");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String nowTime = simpleDateFormat.format(date);
        String t1 = "08:00:00";
        String t2 = "18:00:00";
        int  r1=nowTime.compareTo(t1);
        int  r2=nowTime.compareTo(t2);
        Calendar cal = Calendar.getInstance();
        int nowday = cal.get(Calendar.DAY_OF_WEEK);
//        (nowday>1&&nowday<7)&&(r1>0&&r2<0)
        if(true){
        if(type!=null) {
            if (type.equals("epwd")) {
                epwd(req, resp);
            } else if(type.equals("logout")){
                logout(req,resp);
            }else if(type.equals("getAll"))
            {
                UserService us=new UserServiceImpl();
                PrintWriter out = resp.getWriter();
                List<User> users=us.getAllusers();
                Object userStr = JSON.toJSON(users);
                resp.getWriter().print(userStr);
            } else if(type.equals("getAllroles")){
                System.out.println(type);
                getAllroles(req,resp);
            }
            else if(type.equals("init")) {
                String name = req.getParameter("uid");
                String pwd = req.getParameter("pwd");
                String  MD5pwd= MD5JM.getMD5String(pwd);
                User u1 = us.getUser(name, MD5pwd);

                if (u1!= null && u1.getUnumber()!= 0) {
                    u1.setUnumber(u1.getUnumber()+1);
                    us.updateStuNumber(u1);
                    String n1 = NowTime.ATime();
//                    String n1=NowTime.getNowTiem();
                    u1.setLogintime(n1);
                    us.updateStuSTime(u1);
                    req.getSession().setAttribute("u1",u1);
                    resp.getWriter().print("success");
                }else if (u1!= null && u1.getUnumber()== 0){

                    req.getSession().setAttribute("u1", u1);
                    resp.getWriter().print("ed");

                }else if (u1==null ) {

                    resp.getWriter().print("fail");
                }
            }
        }
       }else {resp.getWriter().print("FFF");}
    }


    protected void epwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd1");
        String  MD5pwd= MD5JM.getMD5String(pwd);
        int uid=Integer.parseInt(req.getParameter("uid"));
        int unumber=Integer.parseInt(req.getParameter("unumber"));
        UserService us=new UserServiceImpl();
        User u1=new User(uid,name,MD5pwd,unumber);
        us.updateStuPwd(u1);
        u1.setUnumber(u1.getUnumber()+1);
        us.updateStuNumber(u1);
        resp.sendRedirect("Login.jsp");

    }
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int uid=Integer.parseInt(req.getParameter("uid"));
        String t2 = NowTime.ATime();
//        String t2=NowTime.getNowTiem();
       User u2=new User();
       u2.setUid(uid);
        u2.setLogouttime(t2);
        us.updateStuETime(u2);
        req.getSession().invalidate();
        resp.getWriter().print("logout");

    }

    protected void getAllroles(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         System.out.println("---get---");

        RoleService rs= new RoleServiceImpl();
        PrintWriter out = resp.getWriter();
        List<role> roles=rs.getAllrole();
        System.out.println(roles);
        Object rolestr = JSON.toJSON(roles);
        resp.getWriter().print(rolestr);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
