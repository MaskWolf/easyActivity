package test.database.service;

import test.database.domain.UserInfo;

public interface UserService {
    /**
     * 通过用户名和密码登录
     * @param user
     * @return
     */
    UserInfo login(UserInfo user);

    /**
     * 用户注册
     * @param registerUser
     * @return
     */
    UserInfo register(UserInfo registerUser);

    /**
     * 判断用户名是否已经存在于数据库
     * @param username
     * @return
     */
    UserInfo isUsername(String username);

    /**
     * 通过uId获取对应用户的头像图片
     * @param uId
     * @return
     */
    String getUserImage(int uId);

    /**
     * 给用户添加默认图片
     * @param uId
     * @param image
     * @return
     */
    String addUserImage(int uId,String image);

    /**
     * 通过用户名得到该用户的所有信息
     * @param uName
     * @return
     */
    UserInfo getUserByuName(String uName);

    /**
     * 通过用户id得到用户信息
     * @param uId
     * @return
     */
    UserInfo getUserByuId(int uId);

    /**
     * 通过用户id修改用户名
     * @param uName
     * @param uId
     */
    void updateuName(String uName,int uId);

    /**
     * 修改用户密码
     * @param uPassword
     * @param uId
     */
    void updatePassword(String uPassword, int uId);

    /**
     * 修改用户签名
     * @param uSignature
     * @param uId
     */
    void updateSignature(String uSignature, int uId);

    /**
     * 修改用户电话
     * @param uPhone
     * @param uId
     */
    void updatePhone(String uPhone, int uId);

    /**
     * 修改用户的邮箱
     * @param uEmail
     * @param uId
     */
    void updateEmail(String uEmail, int uId);
}
