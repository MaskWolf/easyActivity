package test.database.web.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import test.database.domain.*;
import test.database.service.ActivityService;
import test.database.service.Impl.ActivityServiceImpl;
import test.database.service.Impl.ManagerServiceImpl;
import test.database.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/activity/*")
public class ActivityServlet extends BaseServlet {

    private ActivityService activityService = new ActivityServiceImpl();
    private ManagerService managerService = new ManagerServiceImpl();

    /**
     * 获取单个活动的所有信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getSingleActivity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取所有参数
        //活动id
        String aId = request.getParameter("aId");

        //将需要发送到客户端的消息序列化json
        Map<String, Object> mapJson = new HashMap<String, Object>();
        //状态码
        mapJson.put("status", response.getStatus());
        //通过活动名或者用户id得到对应活动的所有信息
        Activity activity = activityService.getSingleActivity(Integer.parseInt(aId));
        if (activity == null) {
            mapJson.put("getMessage", "活动信息获取失败，请检查后重新尝试获取");
            mapJson.put("getSuccess", false);
        } else {
            mapJson.put("getMessage", "活动信息获取成功");
            mapJson.put("getInfoSuccess", true);
        }
        mapJson.put("activityData", activity);
        //获取子活动
        List<ChildActivity> allChildActivity = activityService.getAllChildActivity(Integer.parseInt(aId));
        mapJson.put("childActivityData", allChildActivity);
        //将数据发送到客户端
        writeValue(mapJson, response);
    }

    /**
     * 创建一项活动
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void createActivity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //读取客户端的json数据
        String values = readJson(request);
        //转化为json
        JSONObject json = JSONObject.parseObject(values);

        //获取活动信息
        Activity activity = json.getObject("activity", Activity.class);
        activity.setaCreationTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        activity.setaStatus(true);
        activity.setaNotice("哎呀！该活动暂时还没有公告啊");

        //获取字段名
        JSONArray fieldList = json.getJSONArray("fieldList");
        List<FieldInfo> fieldInfoList = fieldList.toJavaList(FieldInfo.class);

        //获取子活动
        JSONArray childActivities = json.getJSONArray("childActivityList");
        List<ChildActivity> childActivityList = childActivities.toJavaList(ChildActivity.class);
        for (ChildActivity childActivity : childActivityList) {
            childActivity.setCaIsAvailable(true);
        }

        Map<String, Object> mapJson = new HashMap<String, Object>();
        mapJson.put("status", response.getStatus());

        //创建活动
        Activity createActivity = activityService.addActivity(activity);
        if (createActivity != null) {
            //活动创建成功，发布一条动态
            PublishMessage message = new PublishMessage();
            message.setaId(createActivity.getaId());
            message.setuId(0);
            //赞初始为0
            message.setPraiseCount(0);
            //系统发布的为活动简介
            message.setContent(activity.getaDescription());
            int pId = managerService.addPublishMessage(message);

            //添加该活动的字段
            activityService.addFieds(createActivity.getaId(), fieldInfoList);

            //添加子活动
            activityService.addChildActivity(createActivity.getaId(), childActivityList);

            //获取创建活动时自增长的aId
            mapJson.put("aId", createActivity.getaId());
            //添加动态生成的pId
            mapJson.put("pId", pId);
            mapJson.put("createMessage", "创建成功");
            mapJson.put("createSuccess", true);
        } else {
            mapJson.put("aId", -1);
            mapJson.put("pId", -1);
            mapJson.put("createMessage", "创建失败");
            mapJson.put("createSuccess", false);
        }
        writeValue(mapJson, response);
    }

    /**
     * 获取所有创建的活动
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void getAllActivity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Activity> allActivity = activityService.getAllActivity();

        //添加返回到客户端的消息
        Map<String, Object> mapJson = new HashMap<String, Object>();
        //状态码
        mapJson.put("status", response.getStatus());
        if (allActivity == null) {
            //数据库中没有数据，或者查询失败
            //查询消息
            mapJson.put("getMessage", "数据库中没有消息或者查询失败");
            mapJson.put("getSuccess", false);
            mapJson.put("activityData", null);

        } else {
            //查询消息
            mapJson.put("activityMessage", "查询成功");
            mapJson.put("getSuccess", true);
            mapJson.put("activityData", allActivity);
        }
        //将信息输出到界面
        writeValue(mapJson, response);
    }

    /**
     * 得到管理/参与/创建的活动
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void getActivity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取客户端的参数
        String uId = request.getParameter("uId");
        //0 : 创建  1 : 管理   2 : 参与
        String flag = request.getParameter("flag");
        List<Activity> activityList = activityService.getActivity(Integer.parseInt(uId), Integer.parseInt(flag));
        Map<String, Object> mapJson = new HashMap<String, Object>();
        mapJson.put("status", response.getStatus());
        if (activityList == null) {
            if ("0".equals(flag)) {
                mapJson.put("getMessage", "该用户已经创建了0项活动");
            } else if ("1".equals(flag)) {
                mapJson.put("getMessage", "该用户已经管理了0项活动");
            } else {
                mapJson.put("getMessage", "该用户已经参与了0项活动");
            }
            mapJson.put("getSuccess", false);
            mapJson.put("activityData", null);
        } else {
            if ("0".equals(flag)) {
                mapJson.put("getMessage", "该用户已经创建了" + activityList.size() + "项活动");
            } else if ("1".equals(flag)) {
                mapJson.put("getMessage", "该用户已经管理了" + activityList.size() + "项活动");
            } else {
                mapJson.put("getMessage", "该用户已经参与了" + activityList.size() + "项活动");
            }
            mapJson.put("getSuccess", true);
            mapJson.put("activityData", activityList);
        }

        //将数据写回到客户端
        writeValue(mapJson, response);
    }

    /**
     * 得到一个大活动的所有子活动
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void getAllChildActivity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String aId = request.getParameter("aId");
        //得到所有子活动
        List<ChildActivity> childActivityList = activityService.getAllChildActivity(Integer.parseInt(aId));
        Map<String, Object> mapJson = new HashMap<String, Object>();
        mapJson.put("status", response.getStatus());
        mapJson.put("getMessage", "子活动信息获取成功");
        mapJson.put("getSuccess", true);
        mapJson.put("childActivityData", childActivityList);

        //将数据写回到客户端
        writeValue(mapJson, response);
    }

    /**
     * 根据关键字查找活动
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void searchActivity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String aName = request.getParameter("aName");

        //调用service方法查询活动
        List<Activity> activityList = managerService.findActivity(aName);

        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("searchMessage","活动信息搜索成功");
        mapJson.put("searchSuccess",true);
        mapJson.put("activityData",activityList);

        //将数据写回到客户端
        writeValue(mapJson,response);
    }


    /**
     * 修改活动信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void updateActivityInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String aIdString = request.getParameter("aId");
        String flagString = request.getParameter("flag");
        int aId = Integer.parseInt(aIdString);
        int flag = Integer.parseInt(flagString);
        String content = request.getParameter("content");

        //调用service方法修改活动公告
        switch (flag){
            //修改公告
            case 0:{
                activityService.updateNotice(content,aId);
                break;
            }
            //修改地点
            case 1:{
                activityService.updateAddress(content,aId);
                break;
            }
            //修改描述
            case 2:{
                activityService.updateDescription(content,aId);
                break;
            }
        }

        Map<String,Object> mapJson = new HashMap<String,Object>();
        mapJson.put("status",response.getStatus());
        mapJson.put("updateMessage","活动信息更新成功");
        mapJson.put("updateSuccess",true);
        //将数据写回到客户端
        writeValue(mapJson,response);
    }

}
