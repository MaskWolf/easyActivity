package test.database.dao;

import test.database.domain.UserInfo;

public interface UserDao {
    /**
     * 通过用户名和密码登录
     * @param username
     * @param password
     * @return
     */
    UserInfo loginByUsernameAndPassword(String username, String password);

    /**
     * 保存重新注册的用户
     * @param user
     */
    void save(UserInfo user);

    /**
     * 通过用户名查找用户
     * @param uName
     * @return
     */
    UserInfo findUserByuName(String uName);

    /**
     * 通过用户id查找用户
     * @param uId
     * @return
     */
    UserInfo findUserByuId(int uId);

    /**
     * 通过uId获得用户的头像图片
     * @param uId
     * @return
     */
    String getImage(int uId,int flag);

    /**
     * 给用户添加默认图片
     * @param uId
     * @param image
     */
    void addImage(int uId,String image);

    /**
     * 修改用户名
     * @param uName
     * @param uId
     */
    void updateName(String uName,int uId);

    /**
     * 修改密码
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
     * 修改用户邮箱
     * @param uEmail
     * @param uId
     */
    void updateEmail(String uEmail, int uId);
}
