package test.database.service.Impl;

import test.database.dao.ActivityDao;
import test.database.dao.Impl.ActivityDaoImpl;
import test.database.dao.Impl.ManageDaoImpl;
import test.database.dao.ManageDao;
import test.database.domain.*;
import test.database.service.ActivityService;

import java.util.ArrayList;
import java.util.List;


public class ActivityServiceImpl implements ActivityService {

    private ActivityDao activityDao = new ActivityDaoImpl();
    private ManageDao managerDao = new ManageDaoImpl();
    private final String pathFirst = "http://192.168.1.237:8080/test/images/";

    @Override
    public Activity getSingleActivity(String aName) {
        Activity activity = activityDao.findActivityByaName(aName);
        //添加图片
        List<String> images = activityDao.getImages(activity.getaId(), 1);
        activity.setImages(images);
        //添加评论的id
        PublishMessage message = managerDao.getPublishMessages(activity.getaId());
        activity.setpId(message.getpId());
        activity.setPraiseCount(message.getPraiseCount());
        return activity;
    }

    @Override
    public Activity getSingleActivity(int aId) {
        Activity activity = activityDao.findActivityByaId(aId);
        List<String> images = getImages(activity.getaId());
        //添加活动的图片
        activity.setImages(images);
        //添加活动的动态数
        PublishMessage message = managerDao.getPublishMessages(aId);
        activity.setpId(message.getpId());
        activity.setPraiseCount(message.getPraiseCount());
        return activity;
    }

    @Override
    public List<String> getImages(int aId) {
        List<String> imageList = activityDao.getImages(aId, 1);
        List<String> images = new ArrayList<String>();
        for(String image : imageList){
            images.add(pathFirst + image);
        }
        return images;
    }

    @Override
    public Activity addActivity(Activity activity) {
        int aId = activityDao.add(activity);
        return activityDao.getActivityByaId(aId);
    }

    @Override
    public void addFieds(int aId, List<FieldInfo> fieldInfoList) {
        if(fieldInfoList != null){
            for(FieldInfo field : fieldInfoList){
                field.setaId(aId);
                activityDao.addField(aId,field);
            }
        }
    }

    @Override
    public void addChildActivity(int aId, List<ChildActivity> childActivityList) {
        for(ChildActivity childActivity : childActivityList){
            childActivity.setaId(aId);
            activityDao.add(childActivity);
        }
    }

    @Override
    public List<Activity> getAllActivity() {
        List<Activity> allActivity = activityDao.getAllActivity();
        for(Activity activity : allActivity){
            //获取对应活动的所有图片
            List<String> imageList = activityDao.getImages(activity.getaId(), 1);
            List<String> images = new ArrayList<String>();
            for(String image : imageList){
                images.add(pathFirst + image);
            }
            activity.setImages(images);
            //获取对应活动的发布动态pId
            PublishMessage message = managerDao.getPublishMessages(activity.getaId());
            if(message == null){
                activity.setpId(0);
                activity.setPraiseCount(-1);
            }else{
                activity.setpId(message.getpId());
                activity.setPraiseCount(message.getPraiseCount());
            }

        }
        return allActivity;
    }

    @Override
    public List<Activity> getActivity(int uId, int status) {
        List<Activity> activityList = null;
        if(status == 0){
            List<Activity> activities = activityDao.getActivityByuId(uId);
            if(activities == null || activities.size() <= 0){
                return null;
            }
            activityList = new ArrayList<Activity>();
            for(Activity activity : activities){
                //获取与该活动相关的图片
                List<String> images = getImages(activity.getaId());
                activity.setImages(images);
                PublishMessage message = managerDao.getPublishMessages(activity.getaId());
                activity.setpId(message.getpId());
                activity.setPraiseCount(message.getPraiseCount());
                activityList.add(activity);
            }
        }else if(status == 1){
            List<Integer> aIdList = activityDao.getaIdByuId(uId);
            if(aIdList == null || aIdList.size() <= 0){
                return null;
            }
            activityList = new ArrayList<Activity>();
            for(Integer aId : aIdList){
                Activity activity = activityDao.getActivityByaId(aId);
                activityList.add(activity);
            }
        }else{
            List<Integer> caIdList = activityDao.getcaIdByuId(uId);
            if(caIdList == null || caIdList.size() <= 0){
                return null;
            }
            List<Integer> aIdList = new ArrayList<Integer>();
            for(Integer caId : caIdList){
                int aId = activityDao.getaIdBycaId(caId);
                if(!aIdList.contains(aId)){
                    aIdList.add(aId);
                }
            }
            activityList = new ArrayList<Activity>();
            for(Integer aId : aIdList){
                Activity activity = activityDao.getActivityByaId(aId);
                activityList.add(activity);
            }
        }
        for(Activity activity : activityList){
            PublishMessage message = managerDao.getPublishMessages(activity.getaId());
            activity.setpId(message.getpId());
            activity.setPraiseCount(message.getPraiseCount());
        }
        return activityList;
    }

    @Override
    public List<ChildActivity> getAllChildActivity(int aId) {
        return activityDao.getChildActivities(aId);
    }

    @Override
    public void updateNotice(String aNotice, int aId) {
        activityDao.updateNoctice(aNotice,aId);
    }

    @Override
    public void updateAddress(String aAddress, int aId) {
        activityDao.updateAddress(aAddress,aId);
    }

    @Override
    public void updateDescription(String aDescription, int aId) {
        activityDao.updateDescription(aDescription,aId);
    }

    public static void main(String[] args) {
        ActivityService activityService = new ActivityServiceImpl();
        List<Activity> activityList = activityService.getActivity(10, 1);
        for(Activity activity : activityList){
            System.out.println(activity.getaId());
        }
    }

}
