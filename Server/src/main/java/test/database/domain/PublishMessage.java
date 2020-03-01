package test.database.domain;

import java.util.List;

public class PublishMessage {
    private int pId;  //发布动态之后自动生成的id
    private int uId;  //发布该动态的用户，系统为-1
    private int aId;  //与活动相关的aId
    private int praiseCount;       //该动态获得赞数
    private String content;        //动态内容，系统发布的为该活动的简介，用户发布的为自定义
    private List<String> images;    //动态所涉及到的图片
    private UserInfo user;
    private String userImage;
    private List<Comment> commentList;     //存储所有的评论

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PublishMessage{" +
                "pId=" + pId +
                ", uId=" + uId +
                ", aId=" + aId +
                ", praiseCount=" + praiseCount +
                ", content='" + content + '\'' +
                ", images=" + images +
                ", user=" + user +
                '}';
    }
}
