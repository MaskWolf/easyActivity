package top.ljc.easyActivity.Data;

public class User {

    private static int uid = 0;

    private static String uname = "";

    private static boolean sex = false;

    private static String avatar = "";

    private static String phone = "";

    private static String signature = "";

    private static String email = "";

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public static String getSignature() {
        return signature;
    }

    public static void setSignature(String signature) {
        User.signature = signature;
    }

    public static int getUid() {
        return uid;
    }

    public static void setUid(int uid) {
        User.uid = uid;
    }

    public static String getUname() {
        return uname;
    }

    public static void setUname(String uname) {
        User.uname = uname;
    }

    public static boolean getSex() {
        return sex;
    }

    public static void setSex(boolean sex) {
        User.sex = sex;
    }

    public static String getAvatar() {
        return avatar;
    }

    public static void setAvatar(String avatar) {
        User.avatar = avatar;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        User.phone = phone;
    }
}
