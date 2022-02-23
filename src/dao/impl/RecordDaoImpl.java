package dao.impl;

import dao.RecordDao;
import domain.Record;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class RecordDaoImpl implements RecordDao {

    public void add(Record record){
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into record(sno,user_number,ans1,ans2,ans3,ans4,ans5,score) value(?,?,?,?,?,?,?,?)";
            Object params[] = {record.getSno(),record.getUser_number(),record.getAns1(),record.getAns2(),record.getAns3(),record.getAns4(),record.getAns5(),record.getScore()};
            runner.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(String sno,int user_number){
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "delete from record where sno=? and user_number=?";
            Object params[] = {sno, user_number};
            runner.update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public List<Record> find(String sno){
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from record where sno=?";
            Object params[] = {sno};
            return (List<Record>) runner.query(sql,params,new BeanListHandler(Record.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Record find(String sno,int number){
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from record where sno=? and user_number=?";
            Object params[] = {sno,number};
            return runner.query(sql,params,new BeanHandler<Record>(Record.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
