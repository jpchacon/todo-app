package com.chacon.todoapp;

import android.app.Application;

import com.chacon.todoapp.database.AppDatabase;

/**
 * Created by Juanpa on 8/12/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase.getInstance();
    }
}
