package com.example.alfonso.lab01;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity
public class User {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "user_name")
    private String userName;

    @ColumnInfo(name = "password")
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @NonNull
    public int getId() {
        return id;
    }
    public void setId(@NonNull int id) {
        this.id = id;
    }

    // Getters and setters are ignored for brevity,
    // but they're required for Room to work.
}