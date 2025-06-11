package com.hasan.weatherapp.presentation.ui.composable.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.hasan.weatherapp.presentation.ui.theme.PrimaryColor
import com.hasan.weatherapp.presentation.ui.theme.WhiteOrBlack60
import com.hasan.weatherapp.presentation.ui.theme.WhiteOrBlack70
import com.hasan.weatherapp.presentation.ui.theme.WhiteOrBlack8
import com.hasan.weatherapp.presentation.ui.theme.WhiteOrBlack87
import com.hasan.weatherapp.presentation.ui.theme.largeUnit
import com.hasan.weatherapp.presentation.ui.theme.mediumUnit
import com.hasan.weatherapp.presentation.ui.theme.smallUnit
import com.hasan.weatherapp.presentation.ui.theme.tinyUnit
import com.hasan.weatherapp.presentation.ui.theme.titleSectionFontSize
import com.hasan.weatherapp.presentation.ui.theme.xLargeUnit
import com.hasan.weatherapp.presentation.ui.theme.xSmallFontSize

@Composable
fun WeatherTypeCard(
    weatherType: String,
    @DrawableRes weatherIcon: Int,
    title: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier
            .size(height = 128.dp, width = 115.dp)
            .background(
                WhiteOrBlack70, shape = RoundedCornerShape(
                    largeUnit
                )
            )
            .border(1.dp, color = WhiteOrBlack8, shape = RoundedCornerShape(largeUnit))
            .padding(vertical = mediumUnit, horizontal = smallUnit),
        contentAlignment = Alignment.CenterEnd
    ) {
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(
                smallUnit
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(weatherIcon),
                null,
                modifier = Modifier.size(xLargeUnit),
                tint = PrimaryColor
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(tinyUnit)
            ) {
                Text(
                    title,
                    color = WhiteOrBlack87,
                    fontSize = titleSectionFontSize,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TextUnit(0.25f, TextUnitType.Sp),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    weatherType,
                    color = WhiteOrBlack60,
                    fontSize = xSmallFontSize,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = TextUnit(0.25f, TextUnitType.Sp),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}