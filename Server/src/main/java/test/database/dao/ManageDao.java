package test.database.dao;

import test.database.domain.*;

import java.util.List;

public interface ManageDao {

    /**
     * 参与子活动
     * @param str
     */
    void addParticipateMessage(int uId,int caId);


    /**
     * 填写报名信息
     * @param content
     */
    void fill(Content content);


    /**
     * 添加子活动
     * @param childActivity
     */
    void add(ChildActivity childActivity);

    /**
     * 发布评论
     * @param aId
     * @param uId
     */
    void addMessage(int aId, int uId);

    /**
     * 查找pId
     * @param aId
     * @param uId
     * @return
     */
    int findpId(int aId, int uId);

    /**
     * 用户评论
     * @param comment
     */
    void add(Comment comment);


    /**
     * 得到所有的字段信息
     * @param aId
     * @return
     */
    List<FieldInfo> getFields(int aId);

    /**
     * 发布动态
     * @param message
     * @return
     */
    int add(PublishMessage message);

    /**
     * 得到aId对应的活动的所有动态的pId
     * @param aId
     * @return
     */
    PublishMessage getPublishMessages(int aId);

    /**
     * 搜索活动
     * @param aName
     * @return
     */
    List<Activity> searchActivity(String aName);

    /**
     * 得到报名信息
     * @param uId
     * @return
     */
    List<Content> getfieldsMessage(int uId);


    /**
     * 得到用户的所有动态
     * @param uId
     * @return
     */
    List<PublishMessage> getMessage(int uId);

    /**
     *
     * @return
     */
    List<PublishMessage> getTrends();

    /**
     * 获取一个动态的所有评论
     * @param pId
     * @return
     */
    List<Comment> getComments(int pId);

    /**
     * 根据cId获取单条评论
     * @param toCid
     * @return
     */
    Comment getComment(int toCid);

    /**
     * 添加管理员
     * @param aId
     * @param uId
     * @param caId
     * @param mDeadTime
     */
    void add(int aId,int uId,int caId,long mDeadTime);

    /**
     * 删除管理员
     * @param uId
     * @param aId
     */
    void delete(int uId, int aId);

    /**
     * 获取管理员的uId
     * @param aId
     * @return
     */
    List<Integer> getManageruIdByaId(int aId);


    /**
     * 得到管理的子活动
     * @param aid
     * @return
     */
    List<Integer> getcaIdByaId(Integer aid);

    /**
     * 统计报名人数
     * @param fId
     * @return
     */
    int CountNumbers(int fId);

    /**
     * 获取报名该活动的的用户id
     * @param fId
     * @return
     */
    List<Integer> getuIdByfId(int fId);

    /**
     * 根据fId和uId获取报名内容
     * @param uId
     * @param fId
     * @return
     */
    String getContent(int uId, int fId);

    /**
     * 得到最小的成绩
     * @param caId
     * @return
     */
    int getMinScore(int caId);

    /**
     * 得到最大的成绩
     * @param caId
     * @return
     */
    int getMaxScore(int caId);

    /**
     * 更新成绩
     * @param uId
     * @param caId
     * @param score
     */
    void updateSore(int uId, int caId, int score);

    /**
     * 根据uId和aId查找该管理员负责管理的活动,并且以升序的方式给出
     * @param aId
     * @param uId
     * @return
     */
    List<Integer> getCaIdList(int aId, int uId);

    /**
     * 获取元组记录
     * @param min
     * @param max
     * @return
     */
    List<Join> getJoinList(int min, int max);

    /**
     * 设置标志位
     * @param uId
     * @param caId
     */
    void setFlag(int uId, int caId);
}
