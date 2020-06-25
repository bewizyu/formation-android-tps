package com.bewizyu.mvvmarchitecture

import android.app.Application
import timber.log.Timber

class MySmartApp: Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}