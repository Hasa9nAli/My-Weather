package com.hasan.weatherapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val current: Current,
    val daily: Daily,
    val hourly: Hourly,
)