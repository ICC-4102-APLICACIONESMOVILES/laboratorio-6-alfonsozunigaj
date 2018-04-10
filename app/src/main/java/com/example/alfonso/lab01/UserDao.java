package com.example.alfonso.lab01;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;


@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE user_name IN (:userNames)")
    List<User> loadAllByUserNames(String[] userNames);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
