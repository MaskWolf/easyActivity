package test.database.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import test.database.domain.UserInfo;
import test.database.service.Impl.UserServiceImpl;
import test.database.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 用户注册功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到所有的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        String uName = request.getParameter("uName");
        uName = URLEncoder.encode(uName,"utf-8");

        //封装为用户对象
        UserInfo user = new UserInfo();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //获取图片
        String picturePath = null;
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = null;
        try {
            fileItems = upload.parseRequest(request);
            for(FileItem fileItem : fileItems){
                String fieldName = fileItem.getFieldName();
                if ("userImage".equals(fieldName)){
                    picturePath = readPicture(uName, fileItem.getInputStream(), request);
                    break;
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        //判断用户是否输入了个性签名
        String uSignature = request.getParameter("uSignature");
        if("".equals(uSignature) || uSignature == null){
            //没有填写个性签名
            user.setuSignature("这个人很懒，什么也没有留下.......");
        }
        Map<String,Object> mapJson = new HashMap<String,Object>();
        //状态码
        mapJson.put("status",response.getStatus());
        //判断用户输入的验证码是否正确
        if(true){
            //验证码正确
            UserInfo registerUser = userService.register(user);
            if(registerUser != null){
                //注册成功
                //注册信息
                mapJson.put("registerMessage","用户注册成功");
                mapJson.put("registerSuccess",true);
                mapJson.put("registerTime",new Date().getTime());
                //判断用户是否上传的图片
                if("".equals(picturePath) || picturePath == null){
                    //用户没有上传图片，添加默认图片
                    String registerImage = userService.addUserImage(registerUser.getuId(),"1.jpg");
                }else{
                    //用户上传了了图片
                    userService.addUserImage(registerUser.getuId(),uName + ".jpg");
                }
            }else{
                UserInfo existUser = userService.getUserByuName(user.getuName());
                String userImage = userService.getUserImage(existUser.getuId());
                mapJson.put("registerMessage","注册失败，用户数据已经存在");
                mapJson.put("registerSuccess",false);
                mapJson.put("registerTime",new Date().getTime());
            }

        }else{
            //验证码错误
            mapJson.put("checkCode","验证码输入错误");
        }
        //向客户端返回信息
        writeValue(mapJson,response);
    }

    /**
     * 用户登录功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String uName = request.getParameter("uName");
        String uPassword = request.getParameter("uPassword");
        String checkCode = request.getParameter("checkCode");
        //封装用户对象
        UserInfo user = new UserInfo();
        user.setuName(uName);
        user.setuPassword(uPassword);

        //存储需要传输的json信息
        Map<String,Object> mapJson = new HashMap<String,Object>();
        //状态码
        mapJson.put("status",response.getStatus());
        //调用service方法判断输入的登录信息是否正确
        //判断用户名是否存在
        UserInfo isUser = userService.isUsername(user.getuName());
        if(isUser == null){
            //还没有注册
            mapJson.put("loginMessage","该用户还未注册，请注册后登录");
            //用户登录失败
            mapJson.put("loginSuccess",false);
            //登录时间
            mapJson.put("loginTime",new Date().getTime());
            mapJson.put("userData",null);
        }else{
            UserInfo loginUser = userService.login(user);
            if(loginUser != null){
                //登录成功,添加需要传输的信息
                //如果登陆成功，则获取用户的头像图片
                String userImage = userService.getUserImage(loginUser.getuId());
                //System.out.println(userImage);
                //登录成功
                mapJson.put("loginMessage","登录成功");
                //用户是否登录成功过
                mapJson.put("loginSuccess",true);
                mapJson.put("loginTime",new Date().getTime());
                //登录用户的所有基本信息
                mapJson.put("userImage",userImage);
                mapJson.put("userData",loginUser);

            }else{
                //登录失败
                mapJson.put("loginMessage","用户名或者密码输入有误！！");
                //用户是否存在
                mapJson.put("loginSuccess",false);
                mapJson.put("loginTime",new Date().getTime());
                //登录用户的所有基本信息
                mapJson.put("userData",null);
            }
        }
        //传输json信息
        writeValue(mapJson,response);
    }

    /**
     * 修改用户信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取需要修改的用户
        String uIdString = request.getParameter("uId");
        String flagString = request.getParameter("flag");
        String content = request.getParameter("content");
        int uId = Integer.parseInt(uIdString);
        int flag = Integer.parseInt(flagString);
        //调用service方法修改用户名
        switch (flag){
            //修改用户名
            case 0:{
                userService.updateuName(content,uId);
                break;
            }
            //修改密码
            case 1:{
                userService.updatePassword(content,uId);
                break;
            }
            //修改签名
            case 2:{
                userService.updateSignature(content,uId);
                break;
            }
            //修改电话
            case 3:{
                userService.updatePhone(content,uId);
                break;
            }
            //修改邮箱
            case 4:{
                userService.updateEmail(content,uId);
                break;
            }
        }

        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("updateMessage","用户信息修改成功");
        mapJson.put("updateSuccess",true);

        //将数据写会到客户端
        writeValue(mapJson,response);
    }

}
