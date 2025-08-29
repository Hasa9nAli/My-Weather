package com.hasan.weatherapp.data.repository

import com.hasan.weatherapp.data.remote.ApiService
import com.hasan.weatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl(private val apiService: ApiService): WeatherRepository {

    override suspend fun getWeather(latitude: Double, longitude: Double) =
        apiService.getWeather(latitude, longitude)

}

