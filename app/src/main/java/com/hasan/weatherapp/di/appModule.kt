package com.hasan.weatherapp.di

import com.hasan.weatherapp.data.remote.ApiService
import com.hasan.weatherapp.data.repository.WeatherRepositoryImpl
import com.hasan.weatherapp.domain.repository.WeatherRepository
import com.hasan.weatherapp.viewModel.WeatherViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

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

    single { ApiService(get()) }

    single<WeatherRepository> { WeatherRepositoryImpl(get()) }


    single { WeatherViewModel(get()) }
}