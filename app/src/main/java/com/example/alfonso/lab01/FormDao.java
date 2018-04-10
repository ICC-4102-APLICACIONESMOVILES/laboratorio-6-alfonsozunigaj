package com.example.alfonso.lab01;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;


@Dao
public interface FormDao {
    @Query("SELECT * FROM form")
    List<Form> getAll();

    @Query("SELECT * FROM form WHERE id IN (:formIds)")
    List<Form> loadAllByIds(int[] formIds);

    @Insert
    void insert(Form form);

    @Insert
    void insertAll(Form... forms);

    @Delete
    void delete(Form form);
}
