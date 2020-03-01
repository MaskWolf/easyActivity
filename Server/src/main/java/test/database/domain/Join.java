package test.database.domain;

public class Join {
    private int uId;
    private int caId;
    private String joinTime;
    private int score;
    private String uName;
    private String caName;

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getCaId() {
        return caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getCaName() {
        return caName;
    }

    public void setCaName(String caName) {
        this.caName = caName;
    }

    @Override
    public String toString() {
        return "Join{" +
                "uId=" + uId +
                ", caId=" + caId +
                ", joinTime='" + joinTime + '\'' +
                ", score=" + score +
                ", uName='" + uName + '\'' +
                ", caName='" + caName + '\'' +
                '}';
    }
}
