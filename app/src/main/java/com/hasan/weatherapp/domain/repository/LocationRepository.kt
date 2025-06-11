package com.hasan.weatherapp.domain.repository

import com.hasan.weatherapp.domain.repository.model.Location


interface LocationRepository {
    suspend fun getCurrentLocation(): Location
}