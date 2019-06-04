package top.ljc.easyActivity.Data;

import com.google.gson.annotations.SerializedName;

public class TableItem {
    @SerializedName("fieldName")
    private String data;

    @SerializedName("fieldNotice")
    private String example;

    public TableItem() {
        this("","");
    }

    public TableItem(String name, String example) {
        this.data = name;
        this.example = example;
    }

    public String getData() {
        return data;
    }

    public void setData(String name) {
        this.data = name;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
