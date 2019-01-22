package com.myservlet;

import com.alibaba.fastjson.JSON;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.utils.FileSize;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SmartUpload su = new SmartUpload();
        String type = request.getParameter("type");
        System.out.println(type);
        request.getServletContext().getContextPath();
        String realPath = getServletContext().getRealPath("/") + "download/";
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();
        }
        if (type == null){

            String filename = request.getParameter("filename");

//            String filename2 = request.getParameter("filename2");

//            String filename3 = request.getParameter("filename3");

            su.initialize(getServletConfig(), request, response);
            // 设置响应类型
//            su.setContentDisposition(null);
            try {
                su.downloadFile("download/" + filename);

            } catch (SmartUploadException e) {
                e.printStackTrace();
            }
            response.getWriter().write(JSON.toJSONString(1));


        }else{
            String f1 = FileSize.GetFileSize(realPath + "0.jpg");
            String f2 = FileSize.GetFileSize(realPath + "1.jpg");
            String f3 = FileSize.GetFileSize(realPath + "3.jpg");
            List<String> fe = new ArrayList<>();
            fe.add(f1);
            fe.add(f2);
            fe.add(f3);
            response.getWriter().write(JSON.toJSONString(fe));

        }


//        response.setContentType("application/x-msdownload");
//        response.setHeader("Content-Dispositon", "attachment;filename=test.zip");
//
//        String path = getServletContext().getRealPath("/") + "download/";
//        String[] filesname = request.getParameterValues("filesname");
//        ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
//        for (String fs : filesname) {
//            File file = new File(path + fs);
//            zos.putNextEntry(new ZipEntry(fs));
//            FileInputStream fis = new FileInputStream(file);
//            byte[] b = new byte[1024];
//            int n = 0;
//            while ((n = fis.read(b)) != -1) {
//                zos.write(b, 0, n);
//            }
//            zos.flush();
//            fis.close();
//        }
//        zos.setComment("描述信息");
//        zos.flush();
//        zos.close();


    }
}
