package test.database.dao.Impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import test.database.dao.ActivityDao;
import test.database.domain.Activity;
import test.database.domain.ChildActivity;
import test.database.domain.FieldInfo;
import test.database.domain.PublishMessage;
import test.database.utils.JDBCUtils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ActivityDaoImpl implements ActivityDao {

    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());



    @Override
    public Activity findActivityByaName(String aName) {
        //select * from activity where aName = ?
        String sql = "select * from activity where aName = ?";
        Activity activity = null;
        try {
            activity = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Activity>(Activity.class), aName);
        } catch (DataAccessException e) {
            return null;
        }
        return activity;
    }

    @Override
    public Activity findActivityByaId(int aId) {
        //select * from activity where aId = ?
        String sql = "select * from activity where aId = ?";
        Activity activity = null;
        try {
            activity = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Activity>(Activity.class), aId);
        } catch (DataAccessException e) {
            return null;
        }
        return activity;
    }

    @Override
    public List<String> getImages(int aId,int flag) {
        //select url from images where id = ?
        String sql = "select * from images where id = ? and flag = ?";
        List<String> imageList = template.query(sql, new ResultSetExtractor<List<String>>() {


            @Override
            public List<String> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<String> list = new ArrayList<String>();
                while (resultSet.next()) {
                    list.add(resultSet.getString(3));
                }
                return list;
            }
        },aId,flag);
        return imageList;
    }

    @Override
    public int add(final Activity activity) {
        final String sql = "insert into activity values(null,?,?,?,?,?,?,?,?,?,?)";
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        /*template.update(sql,activity.getuId(),
                            activity.getaName(),
                            createTime,
                            deadlineTime,
                            activity.getaParticipation(),
                            activity.getaAbstract(),
                            activity.getaDescription(),
                            activity.getaStatus(),
                            activity.getaNotice(),
                            activity.getaAddress()
                            );*/
        KeyHolder holder = new GeneratedKeyHolder();
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,activity.getuId());
                ps.setString(2,activity.getaName());
                try {
                    ps.setDate(3,new java.sql.Date(sdf.parse(activity.getaCreationTime()).getTime()));
                    ps.setDate(4,new java.sql.Date(sdf.parse(activity.getaDeadlineTime()).getTime()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                ps.setInt(5,activity.getaParticipation());
                ps.setString(6,activity.getaAbstract());
                ps.setString(7,activity.getaDescription());
                ps.setBoolean(8,activity.getaStatus());
                ps.setString(9,activity.getaNotice());
                ps.setString(10,activity.getaAddress());
                return ps;
            }
        },holder);
        return holder.getKey().intValue();
    }

    @Override
    public void addField(int aId, FieldInfo field) {
        String sql = "insert into field values(null,?,?,?)";
        template.update(sql,aId,field.getFieldName(),field.getFieldNotice());
    }

    @Override
    public void add(ChildActivity childActivity) {
        String sql = "insert into childActivity values(null,?,?,?,?,?,?,?,?,?)";
        template.update(sql, childActivity.getaId(),
                            childActivity.getCaName(),
                            childActivity.getCaDescription(),
                            childActivity.getCaScore(),
                            childActivity.getCaDayMaxJoin(),
                            childActivity.isCaIsAvailable(),
                            childActivity.getFlag(),
                            childActivity.getMinScore(),
                            childActivity.getMaxScore());
    }

    @Override
    public List<Activity> getAllActivity() {
        String sql = "select * from activity order by aId DESC ";
        List<Activity> activityList = null;
        try {
            activityList = template.query(sql,
                    new BeanPropertyRowMapper<Activity>(Activity.class));
        } catch (DataAccessException e) {
            return null;
        }
        return activityList;
    }

    @Override
    public List<Activity> getActivityByuId(int uId) {
        String sql = "select * from activity where uId = ?";
        List<Activity> activityList = null;
        try {
            activityList = template.query(sql,
                    new BeanPropertyRowMapper<Activity>(Activity.class), uId);
        } catch (DataAccessException e) {
            return null;
        }
        return activityList;
    }

    @Override
    public Activity getActivityByaId(int aId) {
        String sql = "select * from activity where aId = ?";
        Activity activity = null;
        try {
            activity = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Activity>(Activity.class), aId);
        } catch (DataAccessException e) {
            return null;
        }
        return activity;
    }

    @Override
    public List<Integer> getaIdByuId(int uId) {
        String sql = "select distinct * from manager where uId = ?";
        List<Integer> aIdList = template.query(sql, new ResultSetExtractor<List<Integer>>() {
            @Override
            public List<Integer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Integer> list = new ArrayList<Integer>();
                while (resultSet.next()) {
                    int aId = resultSet.getInt(1);
                    if(!list.contains(aId)){
                        list.add(aId);
                    }
                }
                return list;
            }
        }, uId);
        return aIdList;
    }

    @Override
    public List<Integer> getcaIdByuId(int uId) {
        String sql = "select distinct * from joincaform where uId = ?";
//        try {
//            caIdList = template.query(sql,
//                    new BeanPropertyRowMapper<Integer>(Integer.class), uId);
//        } catch (DataAccessException e) {
//            return null;
//        }
        List<Integer> caIdList = template.query(sql, new ResultSetExtractor<List<Integer>>() {

            @Override
            public List<Integer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Integer> list = new ArrayList<Integer>();
                while (resultSet.next()) {
                    list.add(resultSet.getInt(2));
                }
                return list;
            }
        },uId);
        return caIdList;
    }

    @Override
    public int getaIdBycaId(int caId) {
        String sql = "select aId from childActivity where caId = ?";
        Integer aId = template.queryForObject(sql,
                Integer.class, caId);
        return aId;
    }

    @Override
    public List<ChildActivity> getChildActivities(int aId) {
        String sql = "select * from childActivity where aId = ?";
        List<ChildActivity> childActivityList = null;
        try {
            childActivityList = template.query(sql,
                    new BeanPropertyRowMapper<ChildActivity>(ChildActivity.class),
                    aId);
        } catch (DataAccessException e) {
            return null;
        }
        return childActivityList;
    }

    @Override
    public void updateNoctice(String aNotice, int aId) {
        String sql = "update activity set aNotice = ? where aId = ?";
        template.update(sql,aNotice,aId);
    }

    @Override
    public void updateAddress(String aAddress, int aId) {
        String sql = "update activity set aAddress = ? where aId = ?";
        template.update(sql,aAddress,aId);
    }

    @Override
    public void updateDescription(String aDecription, int aId) {
        String sql = "update activity set aDecription = ? where aId = ?";
        template.update(sql,aDecription,aId);
    }

    @Override
    public ChildActivity findChildActivityBycaId(int caId) {
        String sql = "select * from childactivity where caId = ?";
        ChildActivity childActivity = template.queryForObject(sql,
                new BeanPropertyRowMapper<ChildActivity>(ChildActivity.class), caId);
        return childActivity;
    }

    /*public static void main(String[] args) {
        ActivityDao activityDao = new ActivityDaoImpl();
        List<Activity> allActivity = activityDao.getAllActivity();
        for(Activity activity : allActivity){
            System.out.println(activity);
        }
    }*/
}
