package test.database.test;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import test.database.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/testImage/*")
public class TestServlet extends BaseServlet {
    public void testImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream inputStream = request.getInputStream();
        byte[] bys = new byte[1024];
        int len = 0;

        String path = request.getServletContext().getRealPath("images") + "/test01.jpg";
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(file);

        while((len = inputStream.read(bys)) != -1){
            outputStream.write(bys,0,len);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("testMessage","图片上传成功");
        writeValue(map,response);

    }


    public void testImage02(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FileUploadException {
        //String image = null;
        String uName = request.getParameter("uName");
        InputStream inputStream = null;
        //读取文件
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        for(FileItem item : items){
            String fieldName = item.getFieldName();
            if("image".equals(fieldName)){
                inputStream = item.getInputStream();
                break;
            }
        }
        uName = URLEncoder.encode(uName,"utf-8");
        String path = request.getServletContext().getRealPath("images") + "\\" + uName + ".jpg";
        OutputStream outputStream = new FileOutputStream(path);
        byte[] bys = new byte[1024];
        int len = 0;
        while((len = inputStream.read(bys)) != -1){
            outputStream.write(bys,0,len);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
        writeValue("图片获取成功",response);
    }


}
