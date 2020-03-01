package test.database.dao.Impl;

import org.springframework.jdbc.core.JdbcTemplate;
import test.database.dao.UploadDao;
import test.database.utils.JDBCUtils;

import javax.xml.crypto.Data;
import java.util.Date;

public class UploadDaoImpl implements UploadDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void addPicture(int id, int flag, String url) {
        String sql = "insert into images values(null,?,?,?)";
        template.update(sql,id,url,flag);
    }

    @Override
    public void addPraise(int pId) {
        String sql = "update publishmessage set priaiseCount = praiseCount + 1 where pId = ?";
        template.update(sql,pId);
    }

    @Override
    public void update(int id, int flag, String url) {
        String sql = "update images set url = ? where id = ? and flag = ?";
        template.update(sql,url,id,flag);
    }

    @Override
    public void updateNotice(int aId, String content) {
        String sql = "insert into notice values(null,?,?,?)";
        long time = new Date().getTime();
        template.update(sql,aId,content,time);
    }
}
