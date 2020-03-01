package test.database.service;

import com.alibaba.fastjson.JSONArray;
import test.database.domain.*;

import java.util.List;

public interface ManagerService {

    /**
     * 填写子活动参与信息
     * @param childActivityList
     * @param uId
     */
    void participateChildActivity(int uId,List<Integer> childActivityList);

    /**
     * 填写报名信息
     * @param  uId
     * @param signUpMessage
     */
    void fillContent(int uId, List<Content> signUpMessage);

    /**
     * 添加子活动
     * @param aId
     * @param childActivityList
     */
    void addChildActivity(int aId, List<ChildActivity> childActivityList);

    /**
     * 发布评论
     * @param aId
     * @param uId
     */
    void publish(int aId, int uId);

    /**
     * 得到用户评论的pId
     * @param aId
     * @param uId
     * @return
     */
    int getPublish(int aId, int uId);

    /**
     * 用户添加评论
     * @param comment
     */
    void addComment(Comment comment);

    /**
     * 得到一个大活动的报名字段
     * @param aId
     * @return
     */
    List<FieldInfo> getActivityFieds(int aId);

    /**
     * 发布动态
     * @param message
     * @return
     */
    int addPublishMessage(PublishMessage message);

    /**
     * 根据字段信息获取活动信息
     * @param aName
     * @return
     */
    List<Activity> findActivity(String aName);

    /**
     * 得到报名信息
     * @param parseInt
     * @return
     */
    List<Content> getMessage(int parseInt);

    /**
     * 得到用户的所有动态
     * @param uId
     * @return
     */
    List<PublishMessage> getUserMessage(int uId);

    /**
     * 获取所有用的动态
     * @param flag
     * @return
     */
    List<PublishMessage> getAllTrends(int flag);

    /**
     * 获取一个动态的所有评论
     * @param pId
     * @return
     */
    List<Comment> getComments(int pId);

    /**
     * 添加管理员
     * @param uId
     * @param aId
     * @param mDeadTime
     */
    void addManager(int uId, int aId, long mDeadTime);

    /**
     * 删除管理员
     * @param uId
     * @param aId
     */
    void deleteManger(int uId, int aId);

    /**
     * 获取一个活动的所有管理员
     * @param aId
     * @return
     */
    List<Manager> getAllManager(int aId);

    /**
     * 将活动的报名信息导出到用户邮箱
     * @param aId
     * @param email
     * @return
     */
    boolean exportExcel(int aId,String email);

    /**
     * 记录成绩
     * @param uId
     * @param caId
     * @param score
     * @return
     */
    boolean updateScore(int uId, int caId, int score);

    /**
     * 分配任务
     * @param aId
     * @param uId
     * @return
     */
    List<Join> assignTask(int aId, int uId);
}
