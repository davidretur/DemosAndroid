package com.devcom.ferretaxf

import android.app.Application
import android.os.SystemClock

class Espera : Application() {
    override fun onCreate() {
        super.onCreate()
        SystemClock.sleep(4000)
    }
}