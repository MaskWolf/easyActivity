package top.ljc.easyActivity.Data;

public class ActivityItem {
    private String imageUrl;
    private String title;
    private String desc;

    public ActivityItem() {
    }

    public ActivityItem(String imageUrl, String title, String desc) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
