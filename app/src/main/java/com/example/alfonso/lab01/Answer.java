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

@Entity(foreignKeys = {
        @ForeignKey(
                entity = Question.class,
                parentColumns = "id",
                childColumns = "question_id",
                onDelete = CASCADE
        ),
        @ForeignKey(
            entity = AnswerSet.class,
            parentColumns = "id",
            childColumns = "answer_set_id",
            onDelete = CASCADE
        )
})

public class Answer {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "answer_text")
    private String answer_text;

    @ColumnInfo(name = "question_id")
    private int questionId;

    @ColumnInfo(name = "answer_set_id")
    private int answerSetId;

    public Answer(String answer_text, final int questionId, final int answerSetId) {
        this.answer_text = answer_text;
        this.questionId = questionId;
        this.answerSetId = answerSetId;
    }

    public String getAnswer_text() {
        return answer_text;
    }
    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }
    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public int getAnswerSetId() {
        return answerSetId;
    }
    public void setAnswerSetId(int answerSetId) {
        this.answerSetId = answerSetId;
    }
    @NonNull
    public int getId() {
        return id;
    }
    public void setId(@NonNull int id) {
        this.id = id;
    }
}
