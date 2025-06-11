package com.hasan.weatherapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Current(
    @SerialName("apparent_temperature") val apparentTemperature: Double,
    val interval: Int,
    val precipitation: Double,
    @SerialName("pressure_msl") val pressureMsl: Double,
    val rain: Double,
    @SerialName("relative_humidity_2m") val relativeHumidity2m: Int,
    @SerialName("temperature_2m") val temperature2m: Double,
    val time: String,
    @SerialName("weather_code") val weatherCode: Int,
    @SerialName("wind_speed_10m") val windSpeed10m: Double
)