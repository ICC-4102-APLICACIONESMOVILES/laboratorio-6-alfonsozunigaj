package com.example.alfonso.lab01;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity(foreignKeys = {
        @ForeignKey(
                entity = Form.class,
                parentColumns = "id",
                childColumns = "form_id",
                onDelete = CASCADE
        ),
        @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "user_id",
                onDelete = CASCADE
        )
})

public class AnswerSet {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "form_id")
    private int formId;

    @ColumnInfo(name = "user_id")
    private int userId;

    public AnswerSet(final int formId, final int userId) {
        this.formId = formId;
        this.userId = userId;
    }

    public int getFormId() {
        return formId;
    }
    public void setFormId(int formId) {
        this.formId = formId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    @NonNull
    public int getId() {
        return id;
    }
    public void setId(@NonNull int id) {
        this.id = id;
    }
}
