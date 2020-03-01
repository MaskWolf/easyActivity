package test.database.domain;

import java.util.List;

public class Activity {
    private int aId;   // id
    private int uId;           //创建该活动的用户的用户id
    private String aName;  //活动名称
    private String aCreationTime;  //创建时间
    private String aDeadlineTime;   //活动失效时间
    private int aParticipation;  //参与人数
    private String aAbstract;          //活动摘要
    private String aDescription;  // 活动描述
    private boolean aStatus;         //活动状态
    private String aNotice;        //公告信息
    private String aAddress;        //活动地点
    private List<String> images;  //存储所有图片
    private int pId;      //与该活动相关的id
    private int praiseCount;   //该动态的赞数

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaCreationTime() {
        return aCreationTime;
    }

    public void setaCreationTime(String aCreationTime) {
        this.aCreationTime = aCreationTime;
    }

    public String getaDeadlineTime() {
        return aDeadlineTime;
    }

    public void setaDeadlineTime(String aDeadlineTime) {
        this.aDeadlineTime = aDeadlineTime;
    }

    public int getaParticipation() {
        return aParticipation;
    }

    public void setaParticipation(int aParticipation) {
        this.aParticipation = aParticipation;
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

    public boolean getaStatus() {
        return aStatus;
    }

    public void setaStatus(boolean aStatus) {
        this.aStatus = aStatus;
    }

    public String getaNotice() {
        return aNotice;
    }

    public void setaNotice(String aNotice) {
        this.aNotice = aNotice;
    }

    public String getaAddress() {
        return aAddress;
    }

    public void setaAddress(String aAddress) {
        this.aAddress = aAddress;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "aId=" + aId +
                ", uId=" + uId +
                ", aName='" + aName + '\'' +
                ", aCreationTime='" + aCreationTime + '\'' +
                ", aDeadlineTime='" + aDeadlineTime + '\'' +
                ", aParticipation=" + aParticipation +
                ", aAbstract='" + aAbstract + '\'' +
                ", aDescription='" + aDescription + '\'' +
                ", aStatus=" + aStatus +
                ", aNotice='" + aNotice + '\'' +
                ", aAddress='" + aAddress + '\'' +
                ", iamges=" + images +
                '}';
    }
}
