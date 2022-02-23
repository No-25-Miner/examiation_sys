package service.impl;

import dao.MultipleChoiceDao;
import dao.RecordDao;
import dao.UserDao;
import domain.MultipleChoice;
import domain.Record;
import domain.User;
import utils.DaoFactory;

import java.sql.SQLException;
import java.util.List;

public class SysServiceImpl {

    private UserDao userDao = DaoFactory.getInstance().createDao("dao.impl.UserDaoImpl",UserDao.class);
    private RecordDao recordDao = DaoFactory.getInstance().createDao("dao.impl.RecordDaoImpl",RecordDao.class);
    private MultipleChoiceDao multipleChoiceDao = DaoFactory.getInstance().createDao("dao.impl.MultipleChoiceDaoImpl",MultipleChoiceDao.class);

    public void registerUser(User user) throws SQLException {
        userDao.add(user);
    }

    public void delete(String sno,int user_number){
        recordDao.delete(sno,user_number);
    }

    public User userLogin(String sno, String password) {
        return userDao.find(sno, password);
    }

    public void updateUser(String sno,int number){
        userDao.update(sno,number);
    }

    public void addRecord(Record record){
        recordDao.add(record);
    }

    public Record find(String sno,int number){
        return recordDao.find(sno,number);
    }

    public List<Record> find(String sno){
        return recordDao.find(sno);
    }

    public int findTime(String sno) throws SQLException {
        return userDao.findTime(sno);
    }

    public List<MultipleChoice> find(){
        return multipleChoiceDao.find();
    }

    public List<User> findUser(){
        return userDao.findUser();
    }

}
