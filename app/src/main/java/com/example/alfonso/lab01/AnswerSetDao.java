package com.example.alfonso.lab01;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;


@Dao
public interface AnswerSetDao {
    @Query("SELECT * FROM answerset")
    List<AnswerSet> getAll();

    @Insert
    void insert(AnswerSet answerSet);

    @Insert
    void insertAll(AnswerSet... answerSets);

    @Delete
    void delete(AnswerSet answerSet);
}
