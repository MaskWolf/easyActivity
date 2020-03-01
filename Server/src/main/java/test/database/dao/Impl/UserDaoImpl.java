package test.database.dao.Impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import test.database.dao.UserDao;
import test.database.domain.UserInfo;
import test.database.utils.JDBCUtils;


public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public UserInfo loginByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from userinfo where uName = ? and uPassword = ?";
            UserInfo user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
                    username, password);
            //System.out.println("login:" + user);
            return user;
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }


    @Override
    public void save(UserInfo user) {
        //定义sql
        String sql = "insert into userinfo values(null,?,?,?,?,?,?)";
        template.update(sql,user.getuName(),
                user.getuPassword(),
                user.getuSignature(),
                user.isuSex(),
                user.getuPhone(),
                user.getuEmail());
    }
    @Override
    public UserInfo findUserByuName(String uName) {
        UserInfo user = null;
        try {
            String sql = "select * from userinfo where uName = ?";
            user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
                    uName);
        } catch (DataAccessException e) {
            return null;
        }
        return user;
    }

    @Override
    public UserInfo findUserByuId(int uId) {
        String sql = "select * from userinfo where uId = ?";
        UserInfo user = null;
        try {
            user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<UserInfo>(UserInfo.class),
                    uId);
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
        return user;
    }
    @Override
    public String getImage(int uId, int flag) {
        //select * from images where id = ? and flag = ?
        String sql = "select url from images where id = ? and flag = ?";
        String image = null;
        try {
            image = template.queryForObject(sql, String.class,uId,flag);
        } catch (DataAccessException e) {
            return null;
        }
        return image;
    }

    @Override
    public void addImage(int uId,String image) {
        String sql = "insert into images values(null,?,?,?)";
        template.update(sql,uId,image,0);
    }

    @Override
    public void updateName(String uName,int uId) {
        String sql = "update userinfo set uName = ? where uId = ?";
        template.update(sql,uName,uId);
    }

    @Override
    public void updatePassword(String uPassword, int uId) {
        String sql = "update userinfo set uPassword = ? where uId = ?";
        template.update(sql,uPassword,uId);
    }

    @Override
    public void updateSignature(String uSignature, int uId) {
        String sql = "update userinfo set uSignature = ? where uId = ?";
        template.update(sql,uSignature,uId);
    }

    @Override
    public void updatePhone(String uPhone, int uId) {
        String sql = "update userinfo set uPhone = ? where uId = ?";
        template.update(sql,uPhone,uId);
    }

    @Override
    public void updateEmail(String uEmail, int uId) {
        String sql = "update userinfo set uEmail = ? where uId = ?";
        template.update(sql,uEmail,uId);
    }


    /*public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        String image = userDao.getImage(1, 0);
        System.out.println(image);
    }*/
}
