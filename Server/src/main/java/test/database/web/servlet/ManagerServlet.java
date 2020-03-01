package test.database.web.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import test.database.domain.*;
import test.database.service.ActivityService;
import test.database.service.Impl.ActivityServiceImpl;
import test.database.service.Impl.ManagerServiceImpl;
import test.database.service.Impl.UserServiceImpl;
import test.database.service.ManagerService;
import test.database.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/manager/*")
public class ManagerServlet extends BaseServlet {

    private ManagerService managerService = new ManagerServiceImpl();
    private UserService userService = new UserServiceImpl();
    private ActivityService activityService = new ActivityServiceImpl();

    /**
     * 填写报名信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取客户端发送的json数据
        String values = readJson(request);
        JSONObject json = JSONObject.parseObject(values);
        int aId = json.getInteger("aId");
        int uId = json.getInteger("uId");

        //得到用户填写的报名信息
        JSONArray jsonSignUpMessage = json.getJSONArray("signUpMessage");
        List<Content> signUpMessage = jsonSignUpMessage.toJavaList(Content.class);

        //得到该用户参加的子活动的id
        JSONArray childActivity = json.getJSONArray("childActivity");
        List<Integer> childActivityList = childActivity.toJavaList(Integer.class);

        //填写报名信息
        managerService.fillContent(uId,signUpMessage);

        //添加用户参加的子活动
        managerService.participateChildActivity(uId,childActivityList);


        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("signUpMessage","添加成功");
        mapJson.put("signUpSuccess",true);

        writeValue(mapJson,response);
    }

    /**
     * 添加管理员
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String value = readJson(request);
        JSONObject jsonObject = JSONObject.parseObject(value);
        Integer uId = jsonObject.getInteger("uId");
        Integer aId = jsonObject.getInteger("aId");
        JSONArray caId = jsonObject.getJSONArray("caId");
        */
        String uIdString = request.getParameter("uId");
        String aIdString = request.getParameter("aId");
        System.out.println("String:" + uIdString + "--" + aIdString);
        int uId = Integer.parseInt(uIdString);
        int aId = Integer.parseInt(aIdString);
        System.out.println("Integer:" + uId + "---" + aId);
        String mDeadlineTimeString = request.getParameter("mDeadlineTime");
        System.out.println(mDeadlineTimeString);
        long mDeadTime = Long.parseLong(mDeadlineTimeString);
        managerService.addManager(uId,aId,mDeadTime);

        Map<String,Object> mapJson  = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("addMessage","管理员添加成功");
        mapJson.put("addSuccess",true);
        writeValue(mapJson,response);
    }

    /**
     * 删除管理员
     * @param request
     * @param response
     */
    public void deleteManager(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String uIdString = request.getParameter("uId");
        String aIdString = request.getParameter("aId");
        int uId = Integer.parseInt(uIdString);
        int aId = Integer.parseInt(aIdString);

        managerService.deleteManger(uId,aId);
        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("deleteManager","管理员信息删除成功");
        mapJson.put("deleteSuccess",true);

        writeValue(mapJson,response);
    }

    /**
     * 得到一个活动的所有管理员
     * @param request
     * @param response
     * @throws IOException
     */
    public void getAllManager(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String aIdString = request.getParameter("aId");
        int aId = Integer.parseInt(aIdString);
        List<Manager> managerList = managerService.getAllManager(aId);

        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("getMessage","管理员信息获取成功");
        mapJson.put("getSuccess",true);
        mapJson.put("managerData",managerList);

        writeValue(mapJson,response);
    }

    /**
         * 添加子活动
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
    public void addChildActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取客户端的json字符串
        String values = readJson(request);
        //解析json
        JSONObject json = JSONObject.parseObject(values);

        //获取大活动的aId
        int aId = json.getInteger("aId");
        Map<String,Object> mapJson = new HashMap<String,Object>();
        JSONArray childActivities = json.getJSONArray("childActivityData");

        //获取需要新建的子活动的全部信息
        List<ChildActivity> childActivityList = childActivities.toJavaList(ChildActivity.class);

        //添加子活动
        managerService.addChildActivity(aId,childActivityList);

        mapJson.put("status",response.getStatus());
        mapJson.put("addMessage","添加成功");
        mapJson.put("addSuccess",true);

        //将数据写回到客户端
        writeValue(mapJson,response);

    }

    /**
     * 得到大活动的所有字段信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void getActivityFields(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String aIdString = request.getParameter("aId");
        int aId = Integer.parseInt(aIdString);
        List<FieldInfo> fieldList = managerService.getActivityFieds(aId);
        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("getMessage","字段信息获取成功");
        mapJson.put("getSuccess",true);
        mapJson.put("fields",fieldList);
        writeValue(mapJson,response);
    }

    /**
     * 发布动态
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void publishMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        Map<String, String[]> parameterMap = request.getParameterMap();

        //封装动态对象
        PublishMessage message = new PublishMessage();
        try {
            BeanUtils.populate(message,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //发布评论
        int pId = managerService.addPublishMessage(message);


        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("publishMessage","动态发布成功");
        mapJson.put("publishSuccess",true);
        mapJson.put("pId",pId);
        //将数据写回到客户端
        writeValue(mapJson,response);
    }

    /**
     * 回复评论
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void comment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //封装用户对象
        Comment comment = new Comment();
        try {
            BeanUtils.populate(comment,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        comment.setCommentTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        //调用service方法回复评论
        managerService.addComment(comment);

        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("commentMessage","评论成功");
        mapJson.put("commentSuccess",true);

        //将数据写回到客户端
        writeValue(mapJson,response);
    }

    /**
     * 返回报名内容
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getSignUpMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uId = request.getParameter("uId");
        //调用service方法得到报名信息
        List<Content> contentList = managerService.getMessage(Integer.parseInt(uId));
    }

    /**
     * 得到用户所发的所有动态
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getUserMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uId = request.getParameter("uId");
        //调用service方法处理逻辑业务
        List<PublishMessage> messageList = managerService.getUserMessage(Integer.parseInt(uId));
        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("getMessage","用户的动态信息获取成功");
        mapJson.put("getSucess",true);
        mapJson.put("trends",messageList);
        writeValue(mapJson,response);
    }

    /**
     * 获取所有用户发的动态
     * @param request
     * @param response
     * @throws IOException
     */
    public void getAllTrends(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String flag = request.getParameter("flag");
        //调用service方法处理业务
        List<PublishMessage> messageList = managerService.getAllTrends(Integer.parseInt(flag));
        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("getMessage","动态信息获取成功");
        mapJson.put("getSuccess",true);
        mapJson.put("trends",messageList);
        writeValue(mapJson,response);
    }

    /**
     * 获取一个动态的所有评论
     * @param request
     * @param response
     * @throws IOException
     */
    public void getComments(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取参数
        String pId = request.getParameter("pId");
        //调用service处理业务
        List<Comment> commentList = managerService.getComments(Integer.parseInt(pId));

        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("getMessage","评论信息获取成功过");
        mapJson.put("getSuccess",true);
        mapJson.put("commentData",commentList);

        writeValue(mapJson,response);
    }

    /**
     * 将一个活动的报名表发送到用户的邮箱中
     * @param request
     * @param response
     * @throws IOException
     */
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取参数
        String aIdString = request.getParameter("aId");
        String email = request.getParameter("email");

        int aId = Integer.parseInt(aIdString);

        //调用service方法将活动的报名信息导出到用户的邮箱
        boolean flag = managerService.exportExcel(aId,email);
        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        if(flag){
            mapJson.put("exportMessage","报名信息导出成功，请到邮箱查看");
            mapJson.put("exportSuccess",true);
        }else{
            mapJson.put("exportMessage","报名信息导出失败，请检查是员否连接网络或者联系管理员");
            mapJson.put("exportSuccess",false);
        }

        //将数据写会到客户端
        writeValue(mapJson,response);
    }

    /**
     * 记录成绩
     * @param request
     * @param response
     * @throws IOException
     */
    public void updateScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uIdString = request.getParameter("uId");
        String caIdString = request.getParameter("caId");
        String scoreString = request.getParameter("score");
        int uId = Integer.parseInt(uIdString);
        int caId = Integer.parseInt(caIdString);
        int score = Integer.parseInt(scoreString);

        //调用service方法记录成绩
        managerService.updateScore(uId,caId,score);

        Map<String,Object> mapJson = new HashMap<String, Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("updateMessage","成绩信息上传成功");
        mapJson.put("updateSuccess",true);

        //将数据写会到客户端
        writeValue(mapJson,response);
    }

    /**
     * 为管理员分配参与人员进行记录成绩
     * @param request
     * @param response
     * @throws IOException
     */
    public void assignTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String aIdString = request.getParameter("aId");
        String uIdString = request.getParameter("uId");
        int aId = Integer.parseInt(aIdString);
        int uId = Integer.parseInt(uIdString);
        //调用service方法处理分配业务
        List<Join> joinList = managerService.assignTask(aId,uId);

        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("assignMessage","分配成功");
        mapJson.put("assignSuccess",true);
        mapJson.put("joinData",joinList);

        //将数据写会到客户端
        writeValue(mapJson,response);
    }




}
