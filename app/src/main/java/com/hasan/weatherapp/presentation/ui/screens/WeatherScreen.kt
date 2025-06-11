package com.hasan.weatherapp.presentation.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasan.weatherapp.R
import com.hasan.weatherapp.presentation.ui.composable.TextIcon.LocationTextIcon
import com.hasan.weatherapp.presentation.ui.composable.TextIcon.TemperatureRangeTextIcon
import com.hasan.weatherapp.presentation.ui.composable.card.CardTodayWeather
import com.hasan.weatherapp.presentation.ui.composable.card.DailyWeatherStatusCard
import com.hasan.weatherapp.presentation.ui.composable.card.WeatherTypeCard
import com.hasan.weatherapp.presentation.ui.composable.spacer.SpacerVerticalLarge
import com.hasan.weatherapp.presentation.ui.composable.spacer.SpacerVerticalMedium
import com.hasan.weatherapp.presentation.ui.composable.spacer.SpacerVerticalXSmall
import com.hasan.weatherapp.presentation.ui.composable.spacer.SpacerVerticalXXXLarge
import com.hasan.weatherapp.presentation.ui.theme.BottomGradientColor
import com.hasan.weatherapp.presentation.ui.theme.PrimarySubTextColor
import com.hasan.weatherapp.presentation.ui.theme.PrimaryTextColor
import com.hasan.weatherapp.presentation.ui.theme.TopGradientColor
import com.hasan.weatherapp.presentation.ui.theme.WhiteColor8
import com.hasan.weatherapp.presentation.ui.theme.WhiteOrBlack70
import com.hasan.weatherapp.presentation.ui.theme.ellipse
import com.hasan.weatherapp.presentation.ui.theme.isNightTimeApproximate
import com.hasan.weatherapp.presentation.ui.theme.largeUnit
import com.hasan.weatherapp.presentation.ui.theme.mediumFontSize
import com.hasan.weatherapp.presentation.ui.theme.mediumUnit
import com.hasan.weatherapp.presentation.ui.theme.smallUnit
import com.hasan.weatherapp.presentation.ui.theme.titleSectionFontSize
import com.hasan.weatherapp.presentation.viewModel.WeatherViewModel
import com.skydoves.cloudy.cloudy
import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherScreen(modifier: Modifier) {
    val viewModel: WeatherViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()
    WeatherScreenContent(
        state = state,
        modifier = modifier
    )
}


@Composable
fun WeatherScreenContent(
    state: WeatherScreenUIState,
    modifier: Modifier = Modifier,
) {

    val weathers = listOf(
        WeatherType(
            weatherIcon = R.drawable.ic_fast_wind,
            title = "Wind",
            weatherUnit = "KM/h",
            value = state.wind
        ),
        WeatherType(
            weatherIcon = R.drawable.ic_humidity,
            title = "Humidity",
            weatherUnit = "%",
            value = state.humidity
        ),
        WeatherType(
            weatherIcon = R.drawable.ic_light_53_drizzle_moderate,
            title = "Rain",
            weatherUnit = "%",
            value = state.rain
        ),
        WeatherType(
            weatherIcon = R.drawable.ic_uv_sun,
            title = "UV Index",
            weatherUnit = "",
            value = state.uvIndex
        ),
        WeatherType(
            weatherIcon = R.drawable.ic_arrow_down_boder,
            title = "Pressure",
            weatherUnit = "hPa",
            value = state.pressure
        ),
        WeatherType(
            weatherIcon = R.drawable.ic_temperature,
            title = "Feels like",
            weatherUnit = "°C",
            value = state.feelsLike
        )

    )
    val scrollState = rememberLazyGridState()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        TopGradientColor, BottomGradientColor
                    ),
                )

            )
            .padding(WindowInsets.systemBars.asPaddingValues()),
        state = scrollState,
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            SpacerVerticalXXXLarge()

        }
        item(span = { GridItemSpan(maxLineSpan) }) {
            LocationTextIcon(state.location.cityName)
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            val imageProgress by remember(scrollState) {
                derivedStateOf {
                    (scrollState.firstVisibleItemScrollOffset / 1000f).coerceIn(0f, 1f)
                }
            }

            val targetSize by animateDpAsState(
                targetValue = if (imageProgress < 0.4f) 220.dp else 150.dp,
                animationSpec = tween(1000)
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .offset(
                            x = (-150 * imageProgress).dp,
                            y = (370 * imageProgress).dp
                        ), contentAlignment = Alignment.Center
                ) {
                    if(isNightTimeApproximate()) {
                        Image(
                            painter = painterResource(ellipse),
                            null,
                            modifier = modifier
                                .clip(CircleShape)
                                .cloudy(1000)
                                .offset(-50.dp, 50.dp)
                                .size(targetSize)
                                .animateContentSize(
                                    animationSpec = tween(1000)
                                )

                        )
                    }

                    Image(
                        painter = painterResource(state.currentTemperatureDrawable),
                        null,
                        modifier = modifier
                            .fillMaxWidth()
                            .size(targetSize)
                            .animateContentSize(
                                animationSpec = tween(1000)
                            )

                    )
                }
                SpacerVerticalXSmall()
                val textOffset by remember {
                    derivedStateOf {
                        scrollState.firstVisibleItemScrollOffset.toFloat()
                    }
                }
                val textScale by remember {
                    derivedStateOf {
                        1f - (textOffset / 2000f).coerceIn(0f, 0.5f)
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer {
                            translationX = textOffset * 0.5f
                            scaleX = textScale
                            scaleY = textScale
                        }
                        .animateContentSize(
                            animationSpec = tween(1000)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(smallUnit)
                ) {
                    Text(
                        text = "${state.currentTemperature} °C",
                        fontSize = 64.sp,
                        color = PrimaryTextColor,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = TextUnit(0.25f, TextUnitType.Sp)
                    )
                    Text(
                        text = state.weatherState,
                        fontSize = mediumFontSize,
                        color = PrimarySubTextColor,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TextUnit(0.25f, TextUnitType.Sp)
                    )
                    TemperatureRangeTextIcon(
                        minTemperature = "18°C",
                        maxTemperature = "30°C",
                        modifier = Modifier.padding(top = smallUnit)
                    )
                }
            }
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            SpacerVerticalLarge()
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = mediumUnit),
                verticalArrangement = Arrangement.spacedBy(smallUnit),
                horizontalArrangement = Arrangement.spacedBy(smallUnit)
            ) {
                weathers.forEach {
                    WeatherTypeCard(
                        modifier = Modifier.weight(1f),
                        weatherIcon = it.weatherIcon,
                        title = "${it.value} ${it.weatherUnit}",
                        weatherType = it.title,
                    )
                }

            }

        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            SpacerVerticalLarge()
        }

        item(span = { GridItemSpan(maxLineSpan) }) {

            Text(
                text = "Today",
                fontSize = titleSectionFontSize,
                color = PrimaryTextColor,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = TextUnit(0.25f, TextUnitType.Sp),
                modifier = Modifier.padding(start = mediumUnit)
            )
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            SpacerVerticalMedium()
        }

        item(span = { GridItemSpan(maxLineSpan) }) {

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)

            ) {
                items(state.todayWeather) { data ->
                    CardTodayWeather(
                        weatherIcon = data.first,
                        temperature = "${data.third}°C",
                        time = data.second,
                    )
                }
            }
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            SpacerVerticalLarge()
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(
                text = "Next 7 Days",
                fontSize = titleSectionFontSize,
                color = PrimaryTextColor,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = TextUnit(0.25f, TextUnitType.Sp),
                modifier = Modifier.padding(start = mediumUnit)
            )
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            SpacerVerticalXSmall()

        }
        item(span = { GridItemSpan(maxLineSpan) }) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = mediumUnit)
                    .border(
                        width = 1.dp, color = WhiteColor8, shape = RoundedCornerShape(
                            largeUnit
                        )
                    )
                    .background(WhiteOrBlack70, shape = RoundedCornerShape(24.dp))
            ) {

                state.next7DaysWeather.forEach { dailyForecast ->
                    DailyWeatherStatusCard(
                        image = dailyForecast.weatherIcon,
                        day = dailyForecast.dayName,
                        maxTemperature = "${dailyForecast.maxTemp} C",
                        minTemperature = "${dailyForecast.minTemp} C",
                    )
                }
            }
        }

        item(span = { GridItemSpan(maxLineSpan) }) {
            SpacerVerticalMedium()
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WeatherScreenPreview() {
    WeatherScreen(Modifier.padding(top = 32.dp))
}


data class WeatherType(
    val weatherIcon: Int,
    val title: String,
    val weatherUnit: String,
    val value: String = "0",
)
