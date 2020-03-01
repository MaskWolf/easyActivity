package test.database.test;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import test.database.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test01 {
    public static void main(String[] args) {
        /*KeyHolder holder = new GeneratedKeyHolder();
        jdbc.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, emp.getAge());
                ps.setString(2, emp.getName());
                return ps;
            }
        },holder);

        int newEmpId= holder.getKey().intValue();
        emp.setId(newEmpId);
        return emp;*/
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        KeyHolder holder = new GeneratedKeyHolder();
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                String sql = "insert into test values(null,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,"test");
                preparedStatement.setString(2,"2017961");
                return preparedStatement;
            }
        },holder);
        int newId = holder.getKey().intValue();
        System.out.println(newId);

    }
}
