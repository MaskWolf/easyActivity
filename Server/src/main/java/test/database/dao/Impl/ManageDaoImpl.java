package test.database.dao.Impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import test.database.dao.ManageDao;
import test.database.domain.*;
import test.database.utils.JDBCUtils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManageDaoImpl implements ManageDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public void addParticipateMessage(int uId,int caId) {
        String sql = "insert into joincaform values(?,?,?,0,0)";
        template.update(sql,uId,caId,new Date());
    }

    @Override
    public void fill(Content content) {
        String sql = "insert into applicationcontent values(?,?,?)";
        template.update(sql, content.getfId(),content.getuId(),content.getContent());
    }

    @Override
    public void add(ChildActivity childActivity) {
        String sql = "insert into childactivity values(null,?,?,?,?,?,?)";
        template.update(sql,
                childActivity.getaId(),
                childActivity.getCaName(),
                childActivity.getCaDescription(),
                childActivity.getCaScore(),
                childActivity.getCaDayMaxJoin(),
                childActivity.isCaIsAvailable());
    }

    @Override
    public void addMessage(int aId, int uId) {
        String sql = "insert into publishMessage values(null,?,?,0)";
        template.update(sql,aId,uId);
    }

    @Override
    public int findpId(int aId, int uId) {
        String sql = "select pId where aId = ? and uId = ?";
        Integer pId = template.queryForObject(sql, Integer.class, aId, uId);
        return pId;
    }

    @Override
    public void add(Comment comment) {
        String sql = "insert into comment values(null,?,?,?,?,?)";
        try {
            template.update(sql,comment.getpId(),
                                comment.getFromUid(),
                                comment.getToCid(),
                                comment.getContent(),
                                new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(comment.getCommentTime()).getTime()));
        } catch (ParseException e) {
            return;
        }
    }

    @Override
    public List<FieldInfo> getFields(int aId) {
        String sql = "select * from field where aId = ?";
        List<FieldInfo> fieldInfoList = null;
        try {
            fieldInfoList = template.query(sql,
                    new BeanPropertyRowMapper<FieldInfo>(FieldInfo.class), aId);
        } catch (DataAccessException e) {
            return null;
        }
        return fieldInfoList;
    }

    @Override
    public int add(final PublishMessage message) {
        final String sql = "insert into publishMessage values(null,?,?,?,?)";
        KeyHolder holder = new GeneratedKeyHolder();
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,message.getuId());
                ps.setInt(2,message.getaId());
                ps.setInt(3,message.getPraiseCount());
                ps.setString(4,message.getContent());
                return ps;
            }
        },holder);
        return holder.getKey().intValue();
    }

    @Override
    public PublishMessage getPublishMessages(int aId) {
        String sql = "select * from publishMessage where aId = ?";
        PublishMessage message = null;
        try {
            message = template.queryForObject(sql,
                    new BeanPropertyRowMapper<PublishMessage>(PublishMessage.class), aId);
        } catch (DataAccessException e) {
            return null;
        }
        return message;
    }

    @Override
    public List<Activity> searchActivity(String aName) {
        String sql = "select * from activity where aName like ?";
        List<Activity> activityList = null;
        try {
            activityList = template.query(sql,
                    new BeanPropertyRowMapper<Activity>(Activity.class),
                    "%" + aName + "%");
        } catch (DataAccessException e) {
            return null;
        }
        return activityList;
    }

    @Override
    public List<Content> getfieldsMessage(int uId) {
        String sql = "select * from applicationcontent where uId = ?";
        List<Content> contentList = null;
        try {
            contentList = template.query(sql,
                    new BeanPropertyRowMapper<Content>(Content.class));
        } catch (DataAccessException e) {
            return null;
        }
        return contentList;
    }

    @Override
    public List<PublishMessage> getMessage(int uId) {
        String sql = "select * from publishMessage where uId = ?";
        List<PublishMessage> messageList = null;
        try {
            messageList = template.query(sql,
                    new BeanPropertyRowMapper<PublishMessage>(PublishMessage.class), uId);
        } catch (DataAccessException e) {
            return null;
        }
        return messageList;
    }

    @Override
    public List<PublishMessage> getTrends() {
        String sql = "select * from publishMessage";
        List<PublishMessage> messageList = null;
        try {
            messageList = template.query(sql,
                    new BeanPropertyRowMapper<PublishMessage>(PublishMessage.class));
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
        return messageList;
    }

    @Override
    public List<Comment> getComments(int pId) {
        String sql = "select * from comment where pId = ?";
        List<Comment> commentList = null;
        try {
            commentList = template.query(sql,
                    new BeanPropertyRowMapper<Comment>(Comment.class), pId);
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
        return commentList;
    }

    @Override
    public Comment getComment(int toCid) {
        String sql = "select * from comment where cId = ?";
        Comment comment = null;
        try {
            comment = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Comment>(Comment.class), toCid);
        } catch (DataAccessException e) {
            return null;
        }
        return comment;
    }

    @Override
    public void add(int aId, int uId, int caId, long mDeadTime) {
        String sql = "insert into manager values(?,?,?,?)";
        template.update(sql,
                aId,caId,uId,mDeadTime);
    }

    @Override
    public void delete(int uId, int aId) {
        StringBuilder sb = new StringBuilder("delete from manager where and uId = ?");
        if(aId != 0){
            sb.append(" and aId = ?");
            template.update(sb.toString(),uId,aId);
        }else{
            template.update(sb.toString(),uId);
        }
    }

    @Override
    public List<Integer> getManageruIdByaId(int aId) {
        String sql = "select distinct * from manager where aId = ?";
        List<Integer> uIdList = template.query(sql, new ResultSetExtractor<List<Integer>>() {
            @Override
            public List<Integer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Integer> list = new ArrayList<Integer>();
                while (resultSet.next()) {
                    list.add(resultSet.getInt(3));
                }
                return list;
            }
        }, aId);
        return uIdList;
    }

    @Override
    public List<Integer> getcaIdByaId(Integer aid) {
        String sql = "select distinct * from manager where aId = ?";
        List<Integer> caIdList = template.query(sql, new ResultSetExtractor<List<Integer>>() {
            @Override
            public List<Integer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Integer> list = new ArrayList<Integer>();
                while (resultSet.next()) {
                    list.add(resultSet.getInt(2));
                }
                return list;
            }
        }, aid);
        return caIdList;
    }

    @Override
    public int CountNumbers(int fId) {
        String sql = "select count(*) from applicationcontent where fId = ?";
        return template.queryForObject(sql, Integer.class, fId);
    }

    @Override
    public List<Integer> getuIdByfId(int fId) {
        String sql = "select distinct * from applicationcontent where fId = ?";
        List<Integer> uIdList = template.query(sql, new ResultSetExtractor<List<Integer>>() {
            @Override
            public List<Integer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Integer> list = new ArrayList<Integer>();
                while (resultSet.next()) {
                    list.add(resultSet.getInt(2));
                }
                return list;
            }
        }, fId);
        return uIdList;
    }

    @Override
    public String getContent(int uId, int fId) {
        String sql = "select content from applicationcontent where uId = ? and fId = ?";
        return template.queryForObject(sql,String.class,uId,fId);
    }

    @Override
    public int getMinScore(int caId) {
        String sql = "select minScore from childActivity where caId = ?";
        return template.queryForObject(sql, Integer.class, caId);
    }

    @Override
    public int getMaxScore(int caId) {
        String sql = "select maxScore from childActivity where caId = ?";
        return template.queryForObject(sql,Integer.class,caId);
    }

    @Override
    public void updateSore(int uId, int caId, int score) {
        String sql = "update joinform set score = ? where uId = ? and caId = ?";
        template.update(sql,score,uId,caId);
    }

    @Override
    public List<Integer> getCaIdList(int aId, int uId) {
        String sql = "select * from manager where aId = ? and uId = ? limit ?, ?";
        List<Integer> caIdList = null;
        try {
            caIdList = template.query(sql, new ResultSetExtractor<List<Integer>>() {
                @Override
                public List<Integer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                    List<Integer> list = new ArrayList<Integer>();
                    while (resultSet.next()) {
                        list.add(resultSet.getInt(2));
                    }
                    return list;
                }
            }, aId, uId,0,5);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return caIdList;
    }

    @Override
    public List<Join> getJoinList(int min, int max) {
        String sql = "select * from joincaform where caId <= ? and caId >= ?";
        List<Join> joinList = null;
        try {
            joinList = template.query(sql,
                    new BeanPropertyRowMapper<Join>(Join.class), max, min);
        } catch (DataAccessException e) {
            return null;
        }
        return joinList;
    }

    @Override
    public void setFlag(int uId, int caId) {
        String sql = "update joincaform set flag = 1 where uId = ? and caId = ?";
        template.update(sql,uId,caId);
    }

    public static void main(String[] args) {
        ManageDao manageDao = new ManageDaoImpl();
        /*List<Activity> activityList = manageDao.searchActivity("图灵");
        for(Activity activity : activityList){
            System.out.println(activity);
        }*/
        /*int count = manageDao.CountNumbers(3);
        //System.out.println(count);
        String content = manageDao.getContent(1, 39);
        System.out.println(content);*/
        List<Integer> caIdList = manageDao.getCaIdList(3, 2);
        for(int caId : caIdList){
            System.out.println(caId);
        }

    }
}
