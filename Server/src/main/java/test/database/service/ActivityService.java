package test.database.service;

import test.database.domain.*;

import java.util.List;

public interface ActivityService {
    /**
     * 通过活动名称得到所有活动
     * @param aName
     * @return
     */
    Activity getSingleActivity(String aName);

    /**
     * 通过活动id得到对应的活动
     * @param aId
     * @return
     */
    Activity getSingleActivity(int aId);

    /**
     * 通过aId得到对应活动的所有图片
     * @param aId
     * @return
     */
    List<String> getImages(int aId);

    /**
     * 新创建一项活动
     * @param activity
     * @return
     */
    Activity addActivity(Activity activity);


    /**
     * 添加活动的字段
     * @param aId
     * @param fieldInfoList
     */
    void addFieds(int aId,List<FieldInfo> fieldInfoList);


    /**
     * 添加大活动的子活动
     * @param aId
     * @param childActivityList
     */
    void addChildActivity(int aId, List<ChildActivity> childActivityList);

    /**
     * 查询数据库中的所有活动
     * @return
     */
    List<Activity> getAllActivity();

    /**
     * 得到user用户创建参与或者创建或者管理的活动
     * @param uId
     * @param status
     * @return
     */
    List<Activity> getActivity(int uId, int status);

    /**
     * 通过大活动的id得到所有的子活动
     * @param aId
     * @return
     */
    List<ChildActivity> getAllChildActivity(int aId);

    /**
     * 更新活动公告信息
     * @param aNotice
     * @param aId
     */
    void updateNotice(String aNotice, int aId);

    /**
     * 修改活动地点
     * @param aAddress
     * @param aId
     */
    void updateAddress(String aAddress, int aId);

    /**
     * 修改活动描述
     * @param aDescription
     * @param aId
     */
    void updateDescription(String aDescription, int aId);
}
