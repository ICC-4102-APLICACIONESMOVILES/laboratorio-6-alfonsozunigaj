package com.example.alfonso.lab01;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.res.Configuration;

/**
 * Created by Alfonso on 03-04-2018.
 */

public class MainAplication extends Application {

    static public AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        //Lets get an instance of the database created
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,
                "database-name").build();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
