package com.hasan.weatherapp

import android.app.Application
import com.hasan.weatherapp.di.appModule
import com.hasan.weatherapp.di.networkModule
import com.hasan.weatherapp.di.repoModule
import com.hasan.weatherapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WeatherApp)
            modules(networkModule, appModule, repoModule, viewModelModule)
        }
    }
}