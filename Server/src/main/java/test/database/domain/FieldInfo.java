package test.database.domain;

public class FieldInfo {
    private int fId;
    private int aId;  //对应的那个活动的id
    private String fieldName;  //字段名
    private String fieldNotice;  //字段说明


    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
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

    @Override
    public String toString() {
        return "FieldInfo{" +
                "fId=" + fId +
                ", aId=" + aId +
                ", fieldName='" + fieldName + '\'' +
                ", fieldNotice='" + fieldNotice + '\'' +
                '}';
    }
}
