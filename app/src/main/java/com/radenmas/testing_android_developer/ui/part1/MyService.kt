package com.radenmas.testing_android_developer.ui.part1

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * Created by RadenMas on 14/12/2022.
 */
class MyService : Service() {

    private var myInterface: MyInterface? = null

    var data = "DATA"

    init {
        Log.d("TAG", "Service is running...")
    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("TAG", "Service onStartCommand")
        return START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("TAG", "Service onCreate")
        val str = "Data from Service"

    }

}