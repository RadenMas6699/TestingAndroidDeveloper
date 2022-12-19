package com.radenmas.testing_android_developer.ui.part1.java;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * Created by RadenMas on 16/12/2022.
 */
public class MyServiceJava extends Service {

    private static MyInterfaceJava myInterface;

    public static void setInterfaceJava(Context context) {
        myInterface = (MyInterfaceJava) context;
    }

    public MyServiceJava() {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("TAG", "Service Java running...");

        myInterface.callBackJava("Service running...\nand this is String from Service using Java");

        return START_STICKY;
    }
}
