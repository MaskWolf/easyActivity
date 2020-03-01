package test.database.domain;

public class Comment {
    private int cId;
    private int pId;
    private int fromUid;
    private int toCid;
    private String content;
    private String commentTime;
    private UserInfo toUser;
    private UserInfo fromUser;
    private String fromUserImage;
    private String toUserImage;

    public String getFromUserImage() {
        return fromUserImage;
    }

    public void setFromUserImage(String fromUserImage) {
        this.fromUserImage = fromUserImage;
    }

    public String getToUserImage() {
        return toUserImage;
    }

    public void setToUserImage(String toUserImage) {
        this.toUserImage = toUserImage;
    }

    public UserInfo getFromUser() {
        return fromUser;
    }

    public void setFromUser(UserInfo fromUser) {
        this.fromUser = fromUser;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getFromUid() {
        return fromUid;
    }

    public void setFromUid(int fromUid) {
        this.fromUid = fromUid;
    }

    public int getToCid() {
        return toCid;
    }

    public void setToCid(int toCid) {
        this.toCid = toCid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public UserInfo getToUser() {
        return toUser;
    }

    public void setToUser(UserInfo toUser) {
        this.toUser = toUser;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cId=" + cId +
                ", pId=" + pId +
                ", fromUid=" + fromUid +
                ", toCid=" + toCid +
                ", content='" + content + '\'' +
                ", commentTime='" + commentTime + '\'' +
                ", toUser=" + toUser +
                ", fromUser=" + fromUser +
                ", fromUserImage='" + fromUserImage + '\'' +
                ", toUserImage='" + toUserImage + '\'' +
                '}';
    }
}
