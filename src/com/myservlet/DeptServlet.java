package com.myservlet;

import com.alibaba.fastjson.JSON;
import com.bean.Dept;
import com.service.DeptService;
import com.service.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DeptServlet")
public class DeptServlet extends HttpServlet {
     DeptService ds=new DeptServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        System.out.println("-----servlet里");
        String type = request.getParameter("type");

        if (type.equals("getAll")) {
            List<Dept> allDept = ds.getAllDept();
            response.getWriter().write(JSON.toJSONString(allDept));

        }else if (type.equals("add")){
            addDept(request,response);
        }else if (type.equals("edit")){
            edit(request,response);
        }else if (type.equals("del")){
            del(request,response);
        }else if (type.equals("update")){
            update(request,response);
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("update方法里=====");
        String name = request.getParameter("name");
        System.out.println(name);
//        String did = request.getParameter("did");
        int did = Integer.parseInt(request.getParameter("did"));
        System.out.println("did为"+did);

        Dept dept=new Dept(did,name);
        ds.updateDept(dept);
        System.out.println("修改以后");
        response.getWriter().write(JSON.toJSONString(1));

    }

    private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("del方法里===================");

        int did = Integer.parseInt(request.getParameter("did"));

        System.out.println("did为"+did);
          ds.delDept(did);
        System.out.println("删除成功后");

        response.getWriter().write(JSON.toJSONString(1));

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int  did = Integer.parseInt(request.getParameter("did"));

        Dept deptByDid = ds.getDeptByDid(did);

        response.getWriter().write(JSON.toJSONString(deptByDid));

    }

    private void addDept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        System.out.println("add方法里===================");

        String name = request.getParameter("name");
        System.out.println("name"+name);
        Dept dept = new Dept(0, name);
        ds.addDept(dept);
        response.getWriter().write(JSON.toJSONString(1));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
