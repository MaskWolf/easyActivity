package test.database.domain;



public class UserInfo {
    private int uId;
    private String uName;
    private String uPassword;
    private String uSignature;
    private boolean uSex;
    private String uPhone;
    private String uEmail;

    public UserInfo() {
    }

    public UserInfo(int uId, String uName, String uPassword, String uSignature, boolean uSex, String uPhone, String uEmail) {
        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uSignature = uSignature;
        this.uSex = uSex;
        this.uPhone = uPhone;
        this.uEmail = uEmail;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuSignature() {
        return uSignature;
    }

    public void setuSignature(String uSignature) {
        this.uSignature = uSignature;
    }

    public boolean isuSex() {
        return uSex;
    }

    public void setuSex(boolean uSex) {
        this.uSex = uSex;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uSignature='" + uSignature + '\'' +
                ", uSex=" + uSex +
                ", uPhone='" + uPhone + '\'' +
                ", uEmail='" + uEmail + '\'' +
                '}';
    }
}
