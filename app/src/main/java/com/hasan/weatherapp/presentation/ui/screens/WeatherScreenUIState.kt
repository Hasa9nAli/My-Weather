package com.hasan.weatherapp.presentation.ui.screens

import androidx.annotation.DrawableRes
import com.hasan.weatherapp.R
import com.hasan.weatherapp.domain.repository.model.Location

data class WeatherScreenUIState(
    @DrawableRes val currentTemperatureDrawable:  Int = R.drawable.ic_light_1_mainly_clear,
    val currentTemperature: String = "0",
    val weatherState: String = "0",
    val maxTemperature: String = "0",
    val minTemperature: String = "0",
    val wind: String = "0",
    val humidity: String = "0",
    val rain: String = "0",
    val uvIndex : String = "0",
    val pressure: String = "0",
    val feelsLike: String = "0",
    val location : Location = Location("", 36.3351, 43.1189),
    val todayWeather: List<Triple<Int, String, Double>> = emptyList(),
    val weeklyWeather: List<NextSevenDaysWeatherUIState> = emptyList(),
    val next7DaysWeather : List<DailyForecast> = emptyList()
)



data class NextSevenDaysWeatherUIState(
    val temperatureMax: String = "0",
    val temperatureMin: String = "0",
    val codeIndex: String = "0",
)

data class DailyForecast(
    val dayName: String,
    @DrawableRes val weatherIcon: Int,
    val maxTemp: Double,
    val minTemp: Double
)