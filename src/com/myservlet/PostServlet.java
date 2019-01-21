package com.myservlet;

import com.alibaba.fastjson.JSON;
import com.bean.Dept;
import com.bean.Post;
import com.service.PostService;
import com.service.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {

    PostService ps=new PostServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        System.out.println("-------servlet里");
        String type = request.getParameter("type");
        System.out.println("type为"+type);

        if (type.equals("getAll")) {
            
            getAll(request,response);
//            List<Post> allPost = ps.getAllPost();
//            System.out.println(allPost);
//            response.getWriter().write(JSON.toJSONString(allPost));

        }else if (type.equals("add")){
            addPost(request,response);
        }else if (type.equals("edit")){
             edit(request,response);
        }else if (type.equals("del")){
             del(request,response);
        }else if (type.equals("update")){

            update(request,response);
        }


    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println(name);
        String didstr = request.getParameter("did");

        int did=0;
        if(didstr.trim().length()!=0) {
            did=Integer.parseInt(didstr);
        }

        System.out.println(name+did);
        List<Post> postByNameAndDid = ps.getPostByNameAndDid(name, did);
        System.out.println(postByNameAndDid);
        response.getWriter().write(JSON.toJSONString(postByNameAndDid));
//        List<Post> allPost = ps.getAllPost();
//        System.out.println(allPost);
//        response.getWriter().write(JSON.toJSONString(allPost));

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("update方法里=====");
        String name = request.getParameter("name");
        int pid = Integer.parseInt(request.getParameter("pid"));
        System.out.println(pid);
        int did = Integer.parseInt(request.getParameter("did"));
        System.out.println("pid"+pid+"did"+did);

//        Dept dept=new Dept(did,name);

        Post post = new Post(pid,name,did);
        ps.updatePost(post);

        System.out.println("修改以后");
        response.getWriter().write(JSON.toJSONString(1));


    }


    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int  pid = Integer.parseInt(request.getParameter("pid"));

        Post postByPid = ps.getPostByPid(pid);
        System.out.println(postByPid);
        response.getWriter().write(JSON.toJSONString(postByPid));


    }
    private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("del方法里===================");

        int did = Integer.parseInt(request.getParameter("did"));

        System.out.println("did为"+did);
        ps.delPost(did);

        System.out.println("删除成功后");

        response.getWriter().write(JSON.toJSONString(1));
    }

    private void addPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("add方法里===================");

        String name = request.getParameter("name");
        int did = Integer.parseInt(request.getParameter("did"));



        Post post =new Post(0,name,did);
        ps.addPost(post);
//        ds.addDept(dept);
        response.getWriter().write(JSON.toJSONString(1));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
