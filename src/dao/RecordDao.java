package dao;

import domain.Record;

import java.util.List;

public interface RecordDao {

    void add(Record record);

    Record find(String sno,int number);

    List<Record> find(String sno);

    void delete(String sno,int user_number);
}
