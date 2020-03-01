package test.database.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet("/baseServlet")
public class BaseServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求路径
        String uri = req.getRequestURI();
        //获取方法名称
        String methodName = uri.substring(uri.lastIndexOf('/') + 1);

        try {
            //得到方法
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //执行方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * 将数据序列化为json，写回客户端
     * @param obj
     */
    public void writeValue(Object obj,HttpServletResponse response) throws IOException {
        //将数据序列化为json
        ObjectMapper mapper = new ObjectMapper();
        //设置网页编码格式
        response.setContentType("application/json;charset=utf-8");
        //将数据写回到客户端
        mapper.writeValue(response.getWriter(),obj);
    }

    public String writeValueAsString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    public String readJson(HttpServletRequest request) throws IOException {
        //数据输出流
        ServletInputStream inputStream = request.getInputStream();
        //捕获内存缓冲区的数据，转换成字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = 0;
        byte[] bys = new byte[1024];
        while((len = inputStream.read(bys)) != -1){
            baos.write(bys,0,len);//将流中的数据写到字节数组中
        }
        String json = new String(baos.toByteArray());

        inputStream.close();
        baos.close();
        return json;

    }

    public String readPicture(String name, InputStream inputStream,HttpServletRequest request){
        String path = request.getServletContext().getRealPath("images") + "\\" + name + ".jpg";;
        try {
            OutputStream outputStream = new FileOutputStream(path);
            int len = 0;
            byte[] bys = new byte[1024];
            while((len = inputStream.read(bys)) != -1){
                outputStream.write(bys,0,len);
            }
            outputStream.flush();
            //释放资源
            outputStream.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return name + ".jpg";
    }
}

