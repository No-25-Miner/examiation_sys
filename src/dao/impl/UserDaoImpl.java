package dao.impl;

import dao.UserDao;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;


public class UserDaoImpl implements UserDao {

    public void add(User user) throws SQLException {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into user(sno,username,password,number of times) value(?,?,?,?)";
            Object params[] = {user.getSno(),user.getUsername(),user.getPassword(),0};
            runner.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User find(String sno, String password){
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user where sno=? and password=?";
            Object params[] = {sno, password};
            return (User)runner.query(sql, params, new BeanHandler(User.class));
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<User> findUser(){
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user";
            return (List<User>)runner.query(sql,new BeanListHandler<>(User.class));

        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void update(String sno,int number) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update user set number_of_times=? where sno=?";
            Object params[] = {number,sno};
            runner.update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int findTime(String sno){
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user where sno=?";
            Object params[] = {sno};
            User user = (User)runner.query(sql, params, new BeanHandler(User.class));
            int time =  user.getNumber_of_times();
            return time;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }


    /*public void update(String sno){
        try {
            int newti = findTime(sno);

            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "update user set number_of_times=? where sno=?";
            Object params[] = {newti,sno};
            runner.update(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/


}
