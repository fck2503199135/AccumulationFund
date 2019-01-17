package com.myservlet;

import com.alibaba.fastjson.JSON;
import com.bean.Credit;
import com.jspsmart.upload.SmartUpload;
import com.service.CreditService;
import com.service.CreditServicelmpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/CreditServlet")
public class CreditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
    CreditService cs = new CreditServicelmpl();
    int i;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String type = request.getParameter("type");
        System.out.println(type);
        if (type.equals("add")){
            add(request,response);
        }else if (type.equals("getAll")){
            getAll(request,response);
        }else if (type.equals("goupdate")){
            goupdate(request,response);
        }else if (type.equals("updatedeld")){
            updatedeld(request,response);
        }else if (type.equals("allGo")){
            allGo(request,response);
        }else if (type.equals("allDel")){
            allDel(request,response);
        }else if (type.equals("del")){
            del(request,response);
        }else if (type.equals("getImg")){
            getImg(request,response);
        }else if (type.equals("getbyId")){
            getbyId(request,response);
        }

    }

    protected void getbyId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        int cid = Integer.parseInt(request.getParameter("cid"));
        Credit credit = cs.getbyId(cid);
        response.getWriter().write(JSON.toJSONString(credit));
    }



    protected void getImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        int cid = Integer.parseInt(request.getParameter("cid"));
        Credit img = cs.getImg(cid);
        response.getWriter().write(JSON.toJSONString(img));

    }


    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int cid = Integer.parseInt(request.getParameter("cid"));
        cs.del(cid);
        response.getWriter().write(JSON.toJSONString(1));
    }


    protected void allGo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        List<Credit> credits = cs.allGo();
        response.getWriter().write(JSON.toJSONString(credits));
    }


    protected void allDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        List<Credit> credits = cs.allDel();
        response.getWriter().write(JSON.toJSONString(credits));
    }

    protected void updatedeld(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.getWriter().write(JSON.toJSONString(1));
        int cid = Integer.parseInt(request.getParameter("cid"));
        String deld = request.getParameter("deld");
        cs.updatedeld(new Credit(cid,deld,null));
    }


    protected void goupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.getWriter().write(JSON.toJSONString(1));
        int cid = Integer.parseInt(request.getParameter("cid"));
        String goby = request.getParameter("goby");
        cs.goupdate(new Credit(cid,null,goby));


    }

    protected void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        List<Credit> credits = cs.getAllCredit();
        response.getWriter().write(JSON.toJSONString(credits));

    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 创建图片的存储路径


        i++;
        request.getServletContext().getContextPath();
        String realPath = request.getServletContext().getRealPath("/") + "images";
        //判断路径是否存在  （没有就创建）
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();
        }
        //插件上传 创建上传对象
        SmartUpload sud = new SmartUpload();
        //初始化
        sud.initialize(getServletConfig(), request, response);
        //设置图片大小
        sud.setMaxFileSize(1024 * 1024);
        //可以上传的图片的类型
        sud.setAllowedFilesList("jpg,png,txt");
//        上传方法
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset=GBK");

        try {
            sud.upload();
            sud.save(realPath);
            String fileName = sud.getFiles().getFile(0).getFileName();

            Date date = new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            String cdate = simpleDateFormat.format(date);
            String cname = sud.getRequest().getParameter("cname");
            System.out.println(cname);
            String cnum = sud.getRequest().getParameter("cnum");
            String reason = sud.getRequest().getParameter("option");
            String style = sud.getRequest().getParameter("options");
            cs.addCredit(new Credit(cdate,"GCA100000"+i,cname,cnum,reason,style,"images/" + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
