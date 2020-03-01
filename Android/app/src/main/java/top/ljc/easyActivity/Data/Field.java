package top.ljc.easyActivity.Data;

public class Field {
    private int fid;
    private String fieldName;
    private String fieldNotice;

    public Field() {
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldNotice() {
        return fieldNotice;
    }

    public void setFieldNotice(String fieldNotice) {
        this.fieldNotice = fieldNotice;
    }
}
