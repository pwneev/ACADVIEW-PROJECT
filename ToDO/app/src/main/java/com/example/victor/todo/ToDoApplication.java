package com.example.victor.todo;

import android.app.Application;

import com.firebase.client.Firebase;



public class ToDoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
        // Uncomment the next line to enable disk persistence, which means that the data will be available upon app restarts
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }
}
