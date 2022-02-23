package dao;

import domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    void add(User user) throws SQLException;

    User find(String username, String password);

    void update(String sno,int number);

    int findTime(String sno) throws SQLException;

    List<User> findUser();

}
