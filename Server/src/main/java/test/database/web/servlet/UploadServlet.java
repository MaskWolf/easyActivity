package test.database.web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import test.database.service.Impl.UploadServiceImpl;
import test.database.service.UploadService;
import test.database.utils.UuidUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/upload/*")
public class UploadServlet extends BaseServlet {

    private UploadService uploadService = new UploadServiceImpl();


    /**
     * 上传图片
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void uploadImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = UuidUtil.getUuid();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = null;
        try {
            fileItems = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        String picturePath = null;
        String id = null;
        String flag = null;
        if(fileItems != null){
            for(FileItem fileItem : fileItems){
                String fieldName = fileItem.getFieldName();
                if("image".equals(fieldName)){
                    picturePath = readPicture(name, fileItem.getInputStream(), request);
                }
                if("id".equals(fieldName)){
                    id = fileItem.getString();
                }
                if("flag".equals(fieldName)){
                    flag = fileItem.getString();
                }
            }
        }

        //调用service方法
        String picture = uploadService.uploadPicture(Integer.parseInt(id), Integer.parseInt(flag), picturePath);

        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",200);
        if(picturePath == null){
            mapJson.put("uploadMessage","图片上传失败");
            mapJson.put("uploadSuccess",false);
            mapJson.put("picturePath",null);
        }else{
            mapJson.put("uploadMessage","图片上传成功");
            mapJson.put("uploadSuccess",true);
            mapJson.put("picturePath",picture);
        }
        writeValue(mapJson,response);

    }


    /**
     * 实现点赞功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void uploadPraise(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pId = request.getParameter("pId");
        //点赞
        uploadService.uploadPraise(Integer.parseInt(pId));

        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("uploadMessage","点赞成功");
        mapJson.put("uploadSuccess",true);

        writeValue(mapJson,response);
    }

    /**
     * 发布动态
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void uploadNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aIdString = request.getParameter("aId");
        String content = request.getParameter("content");
        int aId = Integer.parseInt(aIdString);
        //调用service方法发布公告
        uploadService.uploadNotice(aId,content);

        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("uploadMessage","公告发布成功");
        mapJson.put("uploadSuccess",true);

        //将数据写回到客户端
        writeValue(mapJson,response);
    }


}
