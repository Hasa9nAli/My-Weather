package com.hasan.weatherapp.di

import com.hasan.weatherapp.presentation.viewModel.WeatherViewModel
import org.koin.dsl.module

val networkModule = module {
    single { WeatherViewModel(get(), get()) }
}