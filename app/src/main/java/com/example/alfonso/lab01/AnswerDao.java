package com.example.alfonso.lab01;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AnswerDao {
    @Query("SELECT * FROM answer")
    List<Answer> getAll();

    @Insert
    void insert(Answer answer);

    @Insert
    void insertAll(Answer... answers);

    @Delete
    void delete(Answer answer);
}
