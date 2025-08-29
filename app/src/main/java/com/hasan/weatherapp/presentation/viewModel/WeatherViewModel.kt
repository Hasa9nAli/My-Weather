package com.hasan.weatherapp.presentation.viewModel

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasan.weatherapp.R
import com.hasan.weatherapp.data.remote.dto.WeatherResponse
import com.hasan.weatherapp.domain.repository.LocationRepository
import com.hasan.weatherapp.domain.repository.WeatherRepository
import com.hasan.weatherapp.presentation.ui.screens.DailyForecast
import com.hasan.weatherapp.presentation.ui.screens.WeatherScreenUIState
import com.hasan.weatherapp.presentation.ui.theme.isNightTimeApproximate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

class WeatherViewModel(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository,

    ) : ViewModel() {

    private val _state = MutableStateFlow(WeatherScreenUIState())
    val state = _state.asStateFlow()


    init {
        getCurrentLocation()
        getWeather()

    }

    private fun getCurrentLocation() {
        viewModelScope.launch {
            try {
                val location = locationRepository.getCurrentLocation()
                val copyState = _state.value.copy(
                    location = location
                )
                Log.e("WeatherViewModel99", "Error getting current location: $location")
                _state.value = copyState
                Log.e("WeatherViewModel99", "Error getting current location: $location")

            } catch (e: Exception) {
                Log.e("WeatherViewModel", "Error getting current location: ${e.message}")
            }
        }
    }

    private fun getWeather() {
        viewModelScope.launch {
            try {

                val weather = weatherRepository.getWeather(
                    _state.value.location.latitude, _state.value.location.longitude
                )

                val copyState = _state.value.copy(
                    currentTemperatureDrawable = selectTodayDrawable(weather.current.weatherCode),
                    rain = weather.current.rain.toString(),
                    wind = weather.current.windSpeed10m.toString(),
                    pressure = weather.current.pressureMsl.toString(),
                    uvIndex = weather.daily.uvIndexMax[0].toString(),
                    humidity = weather.current.relativeHumidity2m.toString(),
                    feelsLike = weather.current.apparentTemperature.toString(),
                    currentTemperature = weather.current.temperature2m.toString(),
                    weatherState = selectWeatherState(weather.current.weatherCode),
                    todayWeather = getTodayHourlyForecast(weather),
                    next7DaysWeather = getWeeklyForecast(weather).map { dailyForecast ->
                        DailyForecast(
                            dayName = dailyForecast.dayName,
                            weatherIcon = dailyForecast.weatherIcon,
                            maxTemp = dailyForecast.maxTemp,
                            minTemp = dailyForecast.minTemp
                        )
                    })
                _state.value = copyState
                Log.i("WeatherViewModel", "Weather data fetched successfully: ${weather}")
            } catch (e: Exception) {
                Log.i("WeatherViewModel", "Weather data fetched fail: ${e.message}")

            }
        }
    }

    @DrawableRes
    private fun selectTodayDrawable(weatherCode: Int): Int {
        return if (isNightTimeApproximate()) {
            when (weatherCode) {
                0 -> R.drawable.ic_night_0_moon_star
                1 -> R.drawable.ic_night_1_moon_cloud
                2 -> R.drawable.ic_night_2_partly_cloudy
                3 -> R.drawable.ic_night_3_overcast
                45 -> R.drawable.ic_nigth_45_fog
                48 -> R.drawable.ic_night_48_depositing_rime_fog
                51 -> R.drawable.ic_nigth_51_drizzle
                53 -> R.drawable.ic_nigth_53_drizzle_moderate
                55 -> R.drawable.ic_nigth_55_drizzle_intensity
                56 -> R.drawable.ic_nigth_56_freezing_drizzle
                57 -> R.drawable.ic_nigth_57_freezing_drizzle_intensity
                61 -> R.drawable.ic_nigth_61_rain_slight
                63 -> R.drawable.ic_nigth_63_rain_moderate
                65 -> R.drawable.ic_nigth_65_rain_intensity
                66 -> R.drawable.ic_nigth_66_freezing_light
                67 -> R.drawable.ic_nigth_67_freezing_light
                71 -> R.drawable.ic_nigth_71_snow_fall_light
                73 -> R.drawable.ic_nigth_73_snow_fall_moderate
                75 -> R.drawable.ic_nigth_75_snow_fall_intensity
                77 -> R.drawable.ic_nigth_77_snow_grains
                80 -> R.drawable.ic_nigth_80_rain_shower_slight
                81 -> R.drawable.ic_nigth_81_rain_shower_moderate
                82 -> R.drawable.ic_nigth_82_rain_shower_violent
                85 -> R.drawable.ic_nigth_85_snow_shower_slight
                86 -> R.drawable.ic_nigth_86_snow_shower_heavy
                95 -> R.drawable.ic_nigth_95_thunderstrom_slight_or_moderate
                96 -> R.drawable.ic_nigth_96_thunderstrom_with_slight_hail
                99 -> R.drawable.ic_nigth_99_thunderstrom_with_heavy_hail
                else -> R.drawable.ic_night_0_moon_star
            }
        } else {
            when (weatherCode) {
                0 -> R.drawable.ic_light_0_clear_sky
                1 -> R.drawable.ic_light_1_mainly_clear
                2 -> R.drawable.ic_light_2_partly_cloudy
                3 -> R.drawable.ic_light_3_overcast
                45 -> R.drawable.ic_light_45_fog
                48 -> R.drawable.ic_light_48_depositing_rime_fog
                51 -> R.drawable.ic_light_51_drizzle_light
                53 -> R.drawable.ic_light_53_drizzle_moderate
                55 -> R.drawable.ic_light_55_drizzle_intensity
                56 -> R.drawable.ic_light_56_freezing_drizzle_light
                57 -> R.drawable.ic_light_57_freezing_drizzle_intensity
                61 -> R.drawable.ic_light_61_rain_slight
                63 -> R.drawable.ic_light_63_rain_moderate
                65 -> R.drawable.ic_light_65_rain_intensity
                66 -> R.drawable.ic_light_66_freezing_loght
                67 -> R.drawable.ic_light_67_freezing_heavy
                71 -> R.drawable.ic_light_71_snow_fall_light
                73 -> R.drawable.ic_light_73_snow_fall_moderate
                75 -> R.drawable.ic_light_75_snow_fall_intensity
                77 -> R.drawable.ic_light_77_snow_grains
                80 -> R.drawable.ic_light_80_rain_shower_moderate
                81 -> R.drawable.ic_light_81_rain_shower_moderate
                82 -> R.drawable.ic_light_82_rain_shower_violent
                85 -> R.drawable.ic_light_85_snow_grains
                86 -> R.drawable.ic_light_85_snow_grains
                95 -> R.drawable.ic_light_95_thunderstrom_slight_or_moderate
                96 -> R.drawable.ic_light_96_thunderstrom_with_slight_hail
                99 -> R.drawable.ic_light_99_thunderstrom_with_heavy_hail
                else -> R.drawable.ic_light_0_clear_sky
            }
        }
    }


    private fun selectWeatherState(weatherCode: Int): String {
        return when (weatherCode) {
            0 -> "Clear sky"
            1, 2, 3 -> "partly cloudy"
            45, 48 -> "Fog"
            51, 53, 55 -> "Drizzle"
            56, 57 -> "Freezing Drizzle"
            61, 63, 65 -> "Rain"
            66, 67 -> "Freezing Rain"
            71, 73, 75 -> "Snow fall"
            77 -> "Snow grains"
            80, 81, 82 -> "Rain showers"
            85, 86 -> "Snow showers"
            95 -> "Thunderstorm"
            96, 99 -> "Thunderstorm with hail"
            else -> "Unknown weather state"
        }
    }


    private fun getTodayHourlyForecast(response: WeatherResponse): List<Triple<Int, String, Double>> {
        val today = response.daily.time.first()
        val inputFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
        val outputFormatter = DateTimeFormatter.ofPattern("h:mm a")

        return response.hourly.time.zip(response.hourly.temperature2m)
            .zip(response.hourly.weatherCode).filter { (timeTempPair, _) ->
                val (time, _) = timeTempPair
                time.startsWith(today)
            }.map { (timeTempPair, weatherCode) ->
                val (time, temp) = timeTempPair
                val parsedTime = LocalDateTime.parse(time, inputFormatter)
                val formattedTime = parsedTime.format(outputFormatter)
                val drawableRes = selectTodayDrawable(weatherCode)
                Triple(drawableRes, formattedTime, temp)
            }
    }

    private fun getWeeklyForecast(response: WeatherResponse): List<DailyForecast> {
        return response.daily.time.mapIndexed { index, dateString ->
            val date = LocalDate.parse(dateString)
            val dayName = date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())

            DailyForecast(
                dayName = dayName,
                weatherIcon = selectTodayDrawable(response.daily.weatherCode[index]),
                maxTemp = response.daily.temperature2mMax[index],
                minTemp = response.daily.temperature2mMin[index]
            )
        }
    }
}


