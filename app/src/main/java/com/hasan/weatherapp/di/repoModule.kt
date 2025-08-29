package com.hasan.weatherapp.di

import com.hasan.weatherapp.domain.repository.LocationRepository
import com.hasan.weatherapp.data.repository.WeatherRepositoryImpl
import com.hasan.weatherapp.data.repository.LocationRepositoryImpl
import com.hasan.weatherapp.domain.repository.WeatherRepository
import org.koin.dsl.module

val repoModule = module {

    single<WeatherRepository> { WeatherRepositoryImpl(get()) }
    single <LocationRepository>{ LocationRepositoryImpl(get(), get()) }

}