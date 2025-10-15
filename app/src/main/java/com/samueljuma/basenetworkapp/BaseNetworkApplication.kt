package com.samueljuma.basenetworkapp

import android.app.Application
import com.samueljuma.basenetworkapp.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseNetworkApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseNetworkApplication)
            modules(appModules)
        }
    }
}