package com.example.alfonso.lab01;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by Alfonso on 10-04-2018.
 */

@Entity(foreignKeys = @ForeignKey(entity = Form.class,
        parentColumns = "id",
        childColumns = "form_id",
        onDelete = CASCADE))
public class Question {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "question_text")
    private String question_text;

    @ColumnInfo(name = "form_id")
    private String formId;

    public Question(String question_text, final String formId) {
        this.question_text = question_text;
        this.formId = formId;
    }

    public String getQuestion_text() {
        return question_text;
    }
    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }
    public String getFormId() {
        return formId;
    }
    public void setFormId(String formId) {
        this.formId = formId;
    }
    @NonNull
    public int getId() {
        return id;
    }
    public void setId(@NonNull int id) {
        this.id = id;
    }
}
