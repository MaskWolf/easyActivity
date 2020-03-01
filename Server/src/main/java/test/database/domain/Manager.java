package test.database.domain;

import java.util.List;
import java.util.Map;

public class Manager {
    private List<Integer> aIdList;
    private Map<Integer,List<Integer>> caIdMap;
    private int uId;
    private UserInfo user;
    private long mDeadlineTime;

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public List<Integer> getaIdList() {
        return aIdList;
    }

    public void setaIdList(List<Integer> aIdList) {
        this.aIdList = aIdList;
    }

    public Map<Integer, List<Integer>> getCaIdMap() {
        return caIdMap;
    }

    public void setCaIdMap(Map<Integer, List<Integer>> caIdMap) {
        this.caIdMap = caIdMap;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }


    public long getmDeadlineTime() {
        return mDeadlineTime;
    }

    public void setmDeadlineTime(long mDeadlineTime) {
        this.mDeadlineTime = mDeadlineTime;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "aIdList=" + aIdList +
                ", caIdMap=" + caIdMap +
                ", uId=" + uId +
                ", user=" + user +
                ", mDeadlineTime=" + mDeadlineTime +
                '}';
    }
}
