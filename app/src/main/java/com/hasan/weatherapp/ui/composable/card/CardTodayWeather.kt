package com.hasan.weatherapp.ui.composable.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.hasan.weatherapp.R
import com.hasan.weatherapp.ui.theme.BlackColor60
import com.hasan.weatherapp.ui.theme.BlackColor8
import com.hasan.weatherapp.ui.theme.BlackColor87
import com.hasan.weatherapp.ui.theme.WhiteColor70
import com.hasan.weatherapp.ui.theme.mediumUnit
import com.hasan.weatherapp.ui.theme.tinyUnit
import com.hasan.weatherapp.ui.theme.titleFontSize

@Composable
fun CardTodayWeather(
    @DrawableRes weatherIcon: Int,
    temperature: String,
    time: String,
    modifier: Modifier = Modifier,

    ) {
    Box(modifier = Modifier.zIndex(1f)) {
        Box(
            modifier
                .height(120.dp)
                .width(80.dp)
                .border(1.dp, BlackColor8, RoundedCornerShape(20.dp))

                .background(
                    color = WhiteColor70,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(bottom = mediumUnit)
                .zIndex(-1f)
        ) {
            Column(
                Modifier.fillMaxSize()
                .padding(horizontal = mediumUnit)

                    .zIndex(-1f),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = temperature,
                    color = BlackColor87,
                    fontSize = titleFontSize,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = tinyUnit),
                    letterSpacing = TextUnit(0.25f, TextUnitType.Sp),
                    maxLines = 1
                )
                Text(
                    text = time,
                    color = BlackColor60,
                    fontSize = titleFontSize,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1
                )
            }

        }

            Image(
                painter = painterResource(id = weatherIcon),
                contentDescription = null,
                modifier = Modifier
                    .width(58.dp)
                    .height(58.dp)
                    .offset(y = -24.dp)
                    .align(Alignment.TopCenter)
                    .padding(top = mediumUnit)


            )
    }
}

@Composable
@Preview(showBackground = true)
fun CardTodayWeatherPreview() {
    CardTodayWeather(
        weatherIcon = R.drawable.ic_light_1_mainly_clear,
        temperature = "25°C",
        time = "12:00",
        modifier = Modifier
    )
}

