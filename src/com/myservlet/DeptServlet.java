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

        List<Dept> allDept = ds.getAllDept();
        response.getWriter().write(JSON.toJSONString(allDept));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
