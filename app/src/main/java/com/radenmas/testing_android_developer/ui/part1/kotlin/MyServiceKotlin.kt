package com.radenmas.testing_android_developer.ui.part1.kotlin

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log


/**
 * Created by RadenMas on 14/12/2022.
 */
class MyServiceKotlin : Service() {

    private var myInterface: MyInterfaceKotlin = MyObjectKotlin.myInterface

    object MyObjectKotlin {
        lateinit var myInterface: MyInterfaceKotlin

        fun setInterfaceKotlin(context: Context) {
            myInterface = context as MyInterfaceKotlin
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("TAG", "Service Kotlin running...")

        myInterface.callBackKotlin("Service running...\nand this is String from Service using Kotlin")

        return START_STICKY
    }
}