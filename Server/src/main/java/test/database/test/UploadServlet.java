package test.database.test;

import org.apache.poi.xssf.usermodel.*;
import test.database.utils.MailUtils;
import test.database.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/file/*")
public class UploadServlet extends BaseServlet {
    public void uploadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = new ArrayList<User>();
        User user = new User(1,"蕊希",false);
        userList.add(user);
        user = new User(2,"柳丹",false);
        userList.add(user);
        //设置Excel表的基础信息
        String[] headers = {"序号","姓名","性别"};
        String fileName = "学生信息表";

        //得到Excel表的输入流
        InputStream inputStream = exportExcel(headers, userList, fileName, response);

        //发送邮件
        boolean flag = MailUtils.sendMail(inputStream, "wy2017211@163.com", "这个一封学生信息表邮件，无需回复", "测试邮件", "学生信息表");
        if(flag){
            System.out.println("测试邮件发送成功");
        }

    }

    /**
     * 导出信息表
     * @param headers
     * @param list
     * @param fileName
     * @param response
     */
    public static InputStream exportExcel(String[] headers, List<User> list, String fileName, HttpServletResponse response){
        //声明一个工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //生成一个表格
        XSSFSheet sheet = workbook.createSheet(fileName);
        //设置表格默认列宽度是15个字节
        sheet.setDefaultColumnWidth((short)20);
        //产生表格标题行
        XSSFRow row = sheet.createRow(0);
        for(int i = 0;i < headers.length;i++){
            XSSFCell cell = row.createCell(i);
            XSSFRichTextString  text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        try {
            //遍历集合数据，产生数据行
            for(int i = 0;i < list.size();i++){
                //开始填充数据
                row = sheet.createRow(i + 1);
                //利用反射，根据JavaBean的属性的先后顺序，动态调用getXxx()的方法获取属性值
                User user = list.get(i);
                Field[] fields = user.getClass().getDeclaredFields();
                for(int j = 0;j < headers.length;j++){
                    XSSFCell cell = row.createCell(j);
                    String fieldName = fields[j].getName();

                    String getMethodName = ("gender".equals(fieldName) ? "is":"get") + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
                    //获取方法
                    Method method = user.getClass().getMethod(getMethodName, new Class[]{});
                    Object value = method.invoke(user, new Object[]{});
                    String textValue = null;
                    if(value != null && !"".equals(value)){
                        textValue = String.valueOf(value);
                    }
                    if(textValue != null){
                        if("true".equals(textValue)){
                            textValue = "男";
                        }
                        if("false".equals(textValue)){
                            textValue = "女";
                        }
                        XSSFRichTextString textString = new XSSFRichTextString(textValue);
                        cell.setCellValue(textString);
                    }
                }
            }
            //导出Excel表
            ByteArrayOutputStream bos = null;
            bos = new ByteArrayOutputStream();
            workbook.write(bos);
            return new ByteArrayInputStream(bos.toByteArray());
            //getExportFile(workbook,fileName,response);
            //将Excel表发送到用户的邮箱
            //MailUtils.sendMail("wy2017211@163.com",response.getOutputStream(),fileName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void getExportFile(XSSFWorkbook workbook,String name,HttpServletResponse response){
        BufferedOutputStream bos = null;

        try {
            String fileName = name + ".xlsx";
            response.setContentType("application/x-msdownload");
            //设置响应消息头
            response.setHeader("Content-Disposition","attachment;filename=" + new String(fileName.getBytes("gb2312"),"iso-8859-1"));
            bos = new BufferedOutputStream(response.getOutputStream());
            workbook.write(bos);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void ajax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String aIdString = request.getParameter("aId");
        System.out.println(aIdString);
        String data = aIdString;
        writeValue(data,response);
        System.out.println("test");
    }


    }
