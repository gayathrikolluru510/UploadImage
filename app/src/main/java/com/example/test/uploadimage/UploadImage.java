package com.example.test.uploadimage;

import android.app.Application;
import android.content.Context;


import com.google.firebase.database.FirebaseDatabase;

public class UploadImage  extends Application {
    public void onCreate(){
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    }

}