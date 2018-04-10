package com.example.alfonso.lab01;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Alfonso on 02-04-2018.
 */

@Database(entities = {User.class, Form.class, Question.class, AnswerSet.class, Answer.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract FormDao formDao();
    public abstract QuestionDao questionDao();
    public abstract AnswerSetDao answerSetDao();
    public abstract AnswerDao answerDao();
}
