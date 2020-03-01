package test.database.domain;

public class Content {
    private int fId;
    private int uId;
    private String content;

    public Content() {
    }

    public Content(int fId, int uId, String content) {
        this.fId = fId;
        this.uId = uId;
        this.content = content;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Content{" +
                "fId=" + fId +
                ", uId=" + uId +
                ", content='" + content + '\'' +
                '}';
    }
}
