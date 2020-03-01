package top.ljc.easyActivity.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChildActivityItem {
    //子活动唯一表示符号
    @Expose(deserialize = true, serialize = false)
    private int caId;

    //子活动名称
    @Expose(deserialize = true, serialize = true)
    @SerializedName("caName")
    private String name = "";

    //子活动描述
    @Expose(deserialize = true, serialize = true)
    @SerializedName("caDescription")
    private String notice = "";

    //子活动积分
    @Expose(deserialize = true, serialize = true)
    @SerializedName("caScore")
    private int score;

    //子活动每人每日最大参与次数
    @Expose(deserialize = true, serialize = true)
    @SerializedName("caDayMaxJoin")
    private int daymaxjoin;

    //标识子活动是否可以参加
    @Expose(deserialize = true, serialize = false)
    private Boolean caIsAvailable;

    public ChildActivityItem() {
    }

    public ChildActivityItem(String name, String notice) {
        this(name,notice,0,1);
    }

    public ChildActivityItem(String name, String notice, int score, int daymaxjoin) {
        this.name = name;
        this.notice = notice;
        this.score = score;
        this.daymaxjoin = daymaxjoin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDaymaxjoin() {
        return daymaxjoin;
    }

    public void setDaymaxjoin(int daymaxjoin) {
        this.daymaxjoin = daymaxjoin;
    }

    public int getCaId() {
        return caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
    }

    public Boolean getCaIsAvailable() {
        return caIsAvailable;
    }

    public void setCaIsAvailable(Boolean caIsAvailable) {
        this.caIsAvailable = caIsAvailable;
    }
}
