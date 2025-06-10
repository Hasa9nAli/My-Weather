package com.hasan.weatherapp.data.remote

import com.hasan.weatherapp.data.remote.dto.WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(private val client: HttpClient) {
    suspend fun getWeather(latitude: Double, longitude: Double): WeatherResponse {
        return client.get(BASE_URL) {
            parameter("latitude", latitude)
            parameter("longitude", longitude)
            parameter("daily", "temperature_2m_max,temperature_2m_min,weather_code,uv_index_max")
            parameter("hourly", "temperature_2m,weather_code,is_day")
            parameter(
                "current", "temperature_2m,wind_speed_10m,relative_humidity_2m,rain,weather_code,apparent_temperature,pressure_msl,is_day,precipitation"
            )
        }.body()
    }
    companion object {
        const val BASE_URL = "https://api.open-meteo.com/v1/forecast"
    }
}