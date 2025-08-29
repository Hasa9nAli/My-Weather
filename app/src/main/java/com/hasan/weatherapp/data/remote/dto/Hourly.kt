package com.hasan.weatherapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hourly(
    @SerialName("temperature_2m") val temperature2m: List<Double>,
    val time: List<String>,
    @SerialName("weather_code") val weatherCode: List<Int>
)