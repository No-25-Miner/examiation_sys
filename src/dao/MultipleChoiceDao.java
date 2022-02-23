package dao;

import domain.MultipleChoice;

import java.util.List;

public interface MultipleChoiceDao {
    List<MultipleChoice> find();
    String findAnswer();
}
