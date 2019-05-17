package top.ljc.easyActivity.Data;

public class TableItem {
    private String data;
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
