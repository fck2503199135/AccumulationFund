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
import java.util.List;

@WebServlet("/CreditServlet")
public class CreditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
    CreditService cs = new CreditServicelmpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        if (type.equals("add")){
            add(request,response);
        }else if (type.equals("getAll")){
            getAll(request,response);
        }


    }


    protected void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        List<Credit> credits = cs.getAllCredit();
        System.out.println(credits);
        response.getWriter().write(JSON.toJSONString(credits));

    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String cname = request.getParameter("cname");
        // 创建图片的存储路径
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

            String cnum = sud.getRequest().getParameter("cnum");
            String reason = sud.getRequest().getParameter("reason");
            String style = sud.getRequest().getParameter("style");
            cs.addCredit(new Credit(cname,cnum,reason,style,"images/" + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
