package test.database.service.Impl;

import test.database.dao.Impl.UserDaoImpl;
import test.database.dao.UserDao;
import test.database.domain.UserInfo;
import test.database.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    private final String pathFirst = "http://192.168.1.237:8080/test/images/";


    @Override
    public UserInfo login(UserInfo user) {
        UserInfo loginUser = userDao.loginByUsernameAndPassword(user.getuName(), user.getuPassword());
        if(loginUser == null) {
            return null;
        }
        return loginUser;
    }

    @Override
    public UserInfo register(UserInfo user) {
        //通过用户名查询
        UserInfo temp = userDao.findUserByuName(user.getuName());
        if(temp != null){
            //用户名已经存在
            return null;
        }
        //保存用户
        userDao.save(user);
        UserInfo registerUser = userDao.findUserByuName(user.getuName());
        return registerUser;
    }

    @Override
    public UserInfo isUsername(String username) {
        return userDao.findUserByuName(username);
    }


    @Override
    public String getUserImage(int uId) {
        String image = userDao.getImage(uId,0);
        return pathFirst + image;
    }

    @Override
    public String addUserImage(int uId,String image) {
        //添加用户头像
        userDao.addImage(uId,image);
        return pathFirst + image;
    }

    @Override
    public UserInfo getUserByuName(String uName) {
        return userDao.findUserByuName(uName);
    }

    @Override
    public UserInfo getUserByuId(int uId) {
        return userDao.findUserByuId(uId);
    }

    @Override
    public void updateuName(String uName,int uId) {
        userDao.updateName(uName,uId);
    }

    @Override
    public void updatePassword(String uPassword, int uId) {
        userDao.updatePassword(uPassword,uId);
    }

    @Override
    public void updateSignature(String uSignature, int uId) {
        userDao.updateSignature(uSignature,uId);
    }

    @Override
    public void updatePhone(String uPhone, int uId) {
        userDao.updatePhone(uPhone,uId);
    }

    @Override
    public void updateEmail(String uEmail, int uId) {
        userDao.updateEmail(uEmail,uId);
    }

}
