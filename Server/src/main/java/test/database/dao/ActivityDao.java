package test.database.dao;

import test.database.domain.*;

import java.util.List;


public interface ActivityDao {

    /**
     * 通过活动名称查询活动
     * @param aName
     * @return
     */
    Activity findActivityByaName(String aName);

    /**
     * 通过活动的id查询对应的活动
     * @param aId
     * @return
     */
    Activity findActivityByaId(int aId);

    /**
     * 通过aId得到对应的活动图片
     * @param aId
     * @return
     */
    List<String> getImages(int aId,int flag);


    /**
     * 添加一项活动
     * @param activity
     * @return
     */
    int add(Activity activity);

    /**
     * 添加字段
     * @param aId
     * @param field
     */
    void addField(int aId, FieldInfo field);

    /**
     * 添加子活动
     * @param childActivity
     */
    void add(ChildActivity childActivity);

    /**
     * 得到所有的活动
     * @return
     */
    List<Activity> getAllActivity();

    /**
     * 通过用户id查找创建的活动
     * @param uId
     * @return
     */
    List<Activity> getActivityByuId(int uId);

    /**
     * 通过活动的aId查找活动
     * @param aId
     * @return
     */
    Activity getActivityByaId(int aId);

    /**
     * 通过uId查找他所管理的活动
     * @param uId
     * @return
     */
    List<Integer> getaIdByuId(int uId);

    /**
     * 查询对应用户参与的所有子活动的caId
     * @param uId
     * @return
     */
    List<Integer> getcaIdByuId(int uId);

    /**
     * 通过子活动的caId得到活动的aId
     * @param caId
     * @return
     */
    int getaIdBycaId(int caId);

    /**
     * 得到所有的子活动搞
     * @param aId
     * @return
     */
    List<ChildActivity> getChildActivities(int aId);


    /**
     * 更新活动公告
     * @param aNotice
     * @param aId
     */
    void updateNoctice(String aNotice, int aId);

    /**
     * 更新活动地点
     * @param aAddress
     * @param aId
     */
    void updateAddress(String aAddress, int aId);

    /**
     * 更新活动描述
     * @param aDecription
     * @param aId
     */
    void updateDescription(String aDecription, int aId);

    /**
     * 通过caId查找子活动
     * @param caId
     * @return
     */
    ChildActivity findChildActivityBycaId(int caId);
}
