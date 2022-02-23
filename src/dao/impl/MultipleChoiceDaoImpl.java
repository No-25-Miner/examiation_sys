package dao.impl;

import dao.MultipleChoiceDao;
import domain.MultipleChoice;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class MultipleChoiceDaoImpl implements MultipleChoiceDao {

    public List<MultipleChoice> find() {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from multiple_choice";
            return (List<MultipleChoice>)runner.query(sql, new BeanListHandler(MultipleChoice.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public String findAnswer(){
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select answer from multiple_choice";
            String ans= (String) runner.query(sql,new ScalarHandler<String>());
            return ans;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
