package top.ljc.easyActivity.Data;

import java.util.List;

public class Manager {
    /**
     * 管理员用户唯一表示符号
     */
    private int uid;
    /**
     * 用户头像路径
     */
    private String avatarUrl;
    /**
     * 管理员备注名
     */
    private String remarkName;
    /**
     * 管理员管理的子活动
     */
    private List<Integer> caIds;

    public Manager() {
    }

    public Manager(String avatarUrl, String remarkName) {
        this.avatarUrl = avatarUrl;
        this.remarkName = remarkName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public List<Integer> getCaIds() {
        return caIds;
    }

    public void setCaIds(List<Integer> caIds) {
        this.caIds = caIds;
    }
}
