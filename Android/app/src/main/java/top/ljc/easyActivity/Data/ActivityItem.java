package top.ljc.easyActivity.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ActivityItem implements Serializable {
    //活动的唯一标识符
    private int aId;
    //活动对应动态的唯一标识符
    private int pId;
    //活动是否可以参加
    private Boolean aStatus;
    //活动名称
    private String aName;
    //活动参与人数
    private int aParticipation;
    //活动获得的赞数
    private int praiseCount;
    //活动地址
    private String aAddress;
    //活动的一句话简介
    private String aAbstract;
    //活动的详细介绍
    private String aDescription;
    //活动的公告
    private String aNotice;
    //活动的图片集合
    private ArrayList<String > images;
    //活动的创建时间
    private Date aCreationTime;
    //活动的截止时间
    private Date aDeadlineTime;

    public ActivityItem() {
        images = new ArrayList<>();
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public Boolean getaStatus() {
        return aStatus;
    }

    public void setaStatus(Boolean aStatus) {
        this.aStatus = aStatus;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public int getaParticipation() {
        return aParticipation;
    }

    public void setaParticipation(int aParticipation) {
        this.aParticipation = aParticipation;
    }

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }

    public String getaAddress() {
        return aAddress;
    }

    public void setaAddress(String aAddress) {
        this.aAddress = aAddress;
    }

    public String getaAbstract() {
        return aAbstract;
    }

    public void setaAbstract(String aAbstract) {
        this.aAbstract = aAbstract;
    }

    public String getaDescription() {
        return aDescription;
    }

    public void setaDescription(String aDescription) {
        this.aDescription = aDescription;
    }

    public String getaNotice() {
        return aNotice;
    }

    public void setaNotice(String aNotice) {
        this.aNotice = aNotice;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public Date getaCreationTime() {
        return aCreationTime;
    }

    public void setaCreationTime(Date aCreationTime) {
        this.aCreationTime = aCreationTime;
    }

    public Date getaDeadlineTime() {
        return aDeadlineTime;
    }

    public void setaDeadlineTime(Date aDeadlineTime) {
        this.aDeadlineTime = aDeadlineTime;
    }

    public void addImage(String image){
        images.add(image);
    }

    public String getImage(int index){
        if (images.size()>0){
            return images.get(index);
        }
        return null;
    }
}
