package test.database.service.Impl;

import com.alibaba.fastjson.JSONArray;
import org.apache.poi.xssf.usermodel.*;
import test.database.dao.ActivityDao;
import test.database.dao.Impl.ActivityDaoImpl;
import test.database.dao.Impl.ManageDaoImpl;
import test.database.dao.Impl.UserDaoImpl;
import test.database.dao.ManageDao;
import test.database.dao.UserDao;
import test.database.domain.*;
import test.database.service.ManagerService;
import test.database.utils.MailUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ManagerServiceImpl implements ManagerService {

    private ManageDao manageDao = new ManageDaoImpl();
    private ActivityDao activityDao = new ActivityDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private final String pathFirst = "http://192.168.1.237:8080/test/images/";


    @Override
    public void participateChildActivity(int uId,List<Integer> childActivityList) {
        if(childActivityList.size() > 0 && childActivityList != null){
            for(Integer childActivity : childActivityList){
                manageDao.addParticipateMessage(uId,childActivity);
            }
        }

    }

    @Override
    public void fillContent(int uId,List<Content> signUpMessage) {
        if(signUpMessage.size() > 0 && signUpMessage != null){
            for(Content content : signUpMessage){
                content.setuId(uId);
                manageDao.fill(content);
            }
        }
    }

    @Override
    public void addChildActivity(int aId, List<ChildActivity> childActivityList) {
        //添加子活动
        for(ChildActivity childActivity : childActivityList){
            childActivity.setaId(aId);
            manageDao.add(childActivity);
        }
    }

    @Override
    public void publish(int aId, int uId) {
        manageDao.addMessage(aId,uId);
    }

    @Override
    public int getPublish(int aId, int uId) {
        return manageDao.findpId(aId,uId);
    }

    @Override
    public void addComment(Comment comment) {
        manageDao.add(comment);
    }

    @Override
    public List<FieldInfo> getActivityFieds(int aId) {
        return manageDao.getFields(aId);
    }

    @Override
    public int addPublishMessage(PublishMessage message) {
        return manageDao.add(message);
    }

    @Override
    public List<Activity> findActivity(String aName) {
        List<Activity> activityList = manageDao.searchActivity(aName);
        for(Activity activity : activityList){
            List<String> imageList = activityDao.getImages(activity.getaId(), 1);
            List<String> images = new ArrayList<String>();
            for(String image : imageList){
                images.add(pathFirst + image);
            }
            activity.setImages(images);
            PublishMessage message = manageDao.getPublishMessages(activity.getaId());
            activity.setpId(message.getpId());
            activity.setPraiseCount(message.getPraiseCount());
        }
        return activityList;
    }

    @Override
    public List<Content> getMessage(int uId) {
        return manageDao.getfieldsMessage(uId);
    }

    @Override
    public List<PublishMessage> getUserMessage(int uId) {
        List<PublishMessage> messageList = manageDao.getMessage(uId);
        for(PublishMessage message : messageList){
            List<String> imageList = activityDao.getImages(message.getaId(), 2);
            List<String> images = new ArrayList<String>();
            for(String image : imageList){
                images.add(pathFirst + image);
            }
            UserInfo user = userDao.findUserByuId(message.getuId());
            message.setUser(user);
            String image = userDao.getImage(message.getuId(), 0);
            message.setUserImage(pathFirst + image + "?time=" + new Date().getTime());
            message.setImages(images);
            List<Comment> comments = manageDao.getComments(message.getpId());
            message.setCommentList(comments);
        }
        return messageList;
    }

    @Override
    public List<PublishMessage> getAllTrends(int flag) {
        List<PublishMessage> messageList = manageDao.getTrends();
        //存储活动的动态
        List<PublishMessage> activityList = new ArrayList<PublishMessage>();
        //存储用户的动态
        List<PublishMessage> userList = new ArrayList<PublishMessage>();
        for(PublishMessage message : messageList){
            UserInfo user = userDao.findUserByuId(message.getuId());
            message.setUser(user);
            String image = userDao.getImage(message.getuId(), 0);
            message.setUserImage(pathFirst + image + "?time=" + new Date().getTime());
            List<String> imageList = activityDao.getImages(message.getpId(), 2);
            List<String> images = new ArrayList<String>();
            for(String imageString : imageList){
                images.add(pathFirst + imageString);
            }
            message.setImages(images);
            if(message.getuId() > 0){
                userList.add(message);
            }else{
                activityList.add(message);
            }

        }
        if(flag == 0){
            return userList;
        }else{
            return messageList;
        }
        //return messageList;
    }

    @Override
    public List<Comment> getComments(int pId) {
        List<Comment> commentList = manageDao.getComments(pId);
        for(Comment comment : commentList){
            Comment temp = manageDao.getComment(comment.getToCid());
            if(temp != null){
                UserInfo toUser = userDao.findUserByuId(temp.getFromUid());
                String image = userDao.getImage(temp.getFromUid(), 0);
                comment.setToUser(toUser);
                comment.setToUserImage(pathFirst + image + "?time=" + new Date().getTime());
            }else{
                comment.setToUser(null);
            }
            UserInfo fromUser = userDao.findUserByuId(comment.getFromUid());
            comment.setFromUser(fromUser);
            String image = userDao.getImage(comment.getFromUid(), 0);
            comment.setFromUserImage(pathFirst + image + "?time=" + new Date().getTime());
        }
        return commentList;
    }

    @Override
    public void addManager(int uId, int aId, long mDeadTime) {
        List<ChildActivity> childActivities = activityDao.getChildActivities(aId);
        for(ChildActivity childActivity : childActivities){
            manageDao.add(aId,uId,childActivity.getCaId(),mDeadTime);
        }
    }

    @Override
    public void deleteManger(int uId, int aId) {
        manageDao.delete(uId,aId);
    }

    @Override
    public List<Manager> getAllManager(int aId) {
        List<Integer> uIdList = manageDao.getManageruIdByaId(aId);
        List<Manager> managerList = new ArrayList<Manager>();
        for(Integer uId : uIdList){
            Manager manager = new Manager();
            manager.setuId(uId);
            UserInfo user = userDao.findUserByuId(uId);
            manager.setUser(user);
            List<Integer> aIdList = activityDao.getaIdByuId(uId);
            manager.setaIdList(aIdList);
            Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
            for(Integer aid : aIdList){
                List<Integer> caIdList = manageDao.getcaIdByaId(aid);
                map.put(aid,caIdList);
            }
            manager.setCaIdMap(map);
        }
        return managerList;

    }

    @Override
    public boolean exportExcel(int aId,String email) {
        boolean flag = false;
        //活动活动信息
        Activity activity = activityDao.getActivityByaId(aId);
        //从数据库中读取报名信息
        //1.获取报名的字段信息，即headers
        List<FieldInfo> fields = manageDao.getFields(aId);
        //获取报名的总人数
        int count = manageDao.CountNumbers(fields.get(0).getfId());
        //获取该活动的报名人的id
        List<Integer> uIdList = manageDao.getuIdByfId(fields.get(0).getfId());
        //制作Excel表格
        //1.声明一个工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //2.声明一个表格
        XSSFSheet sheet = workbook.createSheet(activity.getaName());
        //设置sheet表格的格式
        sheet.setDefaultColumnWidth(20);
        //产生表格标题行
        XSSFRow row = sheet.createRow(0);
        for(int i = 0;i < fields.size();i++){
            XSSFCell cell = row.createCell(i);
            XSSFRichTextString textString = new XSSFRichTextString(fields.get(i).getFieldName());
            cell.setCellValue(textString);
        }
        /*System.out.println("count:" + count);
        System.out.println("size:" + fields.size());*/
        //遍历集合数据，产生数据行
        for(int i = 0;i < count;i++){
            row = sheet.createRow(i + 1);
            for(int j = 0;j < fields.size();j++){
                XSSFCell cell = row.createCell(j);
                //根据字段名获取信息
                String content = manageDao.getContent(uIdList.get(i),fields.get(j).getfId());
                XSSFRichTextString textString = new XSSFRichTextString(content);
                cell.setCellValue(textString);
            }
        }
        try {
            //导出Excel表
            ByteArrayOutputStream bos = null;
            bos = new ByteArrayOutputStream();
            //将表格信息写到输出流中
            workbook.write(bos);
            InputStream inputStream = new ByteArrayInputStream(bos.toByteArray());
            //发送邮件
            flag = MailUtils.sendMail(inputStream, email, "报名信息见附件", "活动报名表信息", activity.getaName());
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean updateScore(int uId, int caId, int score) {
        boolean flag = false;
        //先查找该成绩的对应范围
        int minScore = manageDao.getMinScore(caId);
        int maxScore = manageDao.getMaxScore(caId);
        if(score <= maxScore && score >= minScore){
            //满足条件，更新成绩
            manageDao.updateSore(uId,caId,score);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Join> assignTask(int aId, int uId) {
        //根据uId和aId查找该管理员负责管理的活动,并且以升序的方式给出
        List<Integer> caIdList = manageDao.getCaIdList(aId,uId);
        int minCaId = caIdList.get(0);
        int maxCaId = caIdList.get(caIdList.size() - 1);
        //得到需要填报成绩的元组,取出5条
        List<Join> joinList = manageDao.getJoinList(minCaId,maxCaId);
        //将这5条记录的flag设置为1，标志处于记录成绩的状态
        for(Join join : joinList){
            UserInfo user = userDao.findUserByuId(join.getuId());
            ChildActivity childActivity = activityDao.findChildActivityBycaId(join.getCaId());
            join.setuName(user.getuName());
            join.setCaName(childActivity.getCaName());
            manageDao.setFlag(join.getuId(),join.getCaId());
        }
        return joinList;
    }


    public static void main(String[] args) {
        ManagerService managerService = new ManagerServiceImpl();
        /*List<PublishMessage> allTrends = managerService.getAllTrends(0);
        for(PublishMessage message : allTrends){
            System.out.println(message.getImages().size());
        }*/
        boolean flag = managerService.exportExcel(1,"wy2017211@163.com");
        System.out.println(flag);
    }
}
