package com.example.alfonso.lab01;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuestionDao {
    @Query("SELECT * FROM question")
    List<Question> getAll();

    @Query("SELECT * FROM question WHERE form_id = :formId")
    List<Question> loadAllById(int formId);

    @Insert
    void insert(Question question);

    @Insert
    void insertAll(Question... question);

    @Delete
    void delete(Question question);
}
