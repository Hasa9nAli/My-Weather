package com.hasan.weatherapp.di

import android.location.Geocoder
import com.google.android.gms.location.LocationServices
import com.hasan.weatherapp.data.remote.ApiService
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.util.Locale

val appModule = module {

    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                })
            }
        }
    }
    single {
        LocationServices.getFusedLocationProviderClient(androidContext())
    }
    single {
        Geocoder(androidContext(), Locale.ENGLISH)
    }

    single { ApiService(get()) }





}