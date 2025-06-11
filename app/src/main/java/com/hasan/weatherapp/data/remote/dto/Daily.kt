package com.hasan.weatherapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Daily(
    @SerialName("temperature_2m_max") val temperature2mMax: List<Double>,
    @SerialName("temperature_2m_min")val temperature2mMin: List<Double>,
    val time: List<String>,
    @SerialName("uv_index_max") val uvIndexMax: List<Double>,
    @SerialName("weather_code") val weatherCode: List<Int>
)