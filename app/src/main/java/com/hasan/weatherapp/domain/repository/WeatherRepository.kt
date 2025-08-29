package com.hasan.weatherapp.domain.repository

import com.hasan.weatherapp.data.remote.dto.WeatherResponse


interface WeatherRepository {
    suspend fun getWeather(latitude: Double, longitude: Double): WeatherResponse
}