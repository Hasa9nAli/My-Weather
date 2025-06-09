package com.hasan.weatherapp.ui.composable.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.hasan.weatherapp.R
import com.hasan.weatherapp.ui.theme.BlackColor60
import com.hasan.weatherapp.ui.theme.BlackColor8
import com.hasan.weatherapp.ui.theme.BlackColor87
import com.hasan.weatherapp.ui.theme.mediumFontSize
import com.hasan.weatherapp.ui.theme.mediumUnit
import com.hasan.weatherapp.ui.theme.tinyUnit
import com.hasan.weatherapp.ui.theme.xLargeUnit
import com.hasan.weatherapp.ui.theme.xSmallFontSize
import com.hasan.weatherapp.ui.theme.xSmallUnit

@Composable
fun DailyWeatherStatusCard(
    @DrawableRes image: Int,
    day: String,
    maxTemperature: String,
    minTemperature: String,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(61.dp)
                .background(
                    brush =
                        Brush.linearGradient(
                            colors = listOf(
                                Color(0x00FFFFFF), Color(0xFFFFFFFF)
                            ),
                            start = Offset(0f, 0f),
                            end = Offset(0f, 1000f)
                        ),

                    ).padding(horizontal = mediumUnit),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Text(
                modifier = Modifier.width(128.dp),
                text = day, fontSize = mediumFontSize,
                color = BlackColor60,
                fontWeight = FontWeight.Normal,
                letterSpacing = TextUnit(0.25f, TextUnitType.Sp)
            )
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(xLargeUnit + tinyUnit + 2.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    tinyUnit
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_down),
                        null,
                        modifier = Modifier.rotate(180f).size(xSmallUnit),
                        tint = BlackColor87

                    )
                    Text(
                        text = maxTemperature,
                        fontSize = xSmallFontSize,
                        color = BlackColor87,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TextUnit(0.25f, TextUnitType.Sp)
                    )
                }
                Spacer(
                    modifier = Modifier.height(tinyUnit).width(1.dp).background(Color(0x05000000))
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_down),
                        null,
                        modifier = Modifier.size(xSmallUnit),
                        tint = BlackColor87

                    )
                    Text(
                        text = minTemperature,
                        fontSize = xSmallFontSize,
                        color = BlackColor87,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TextUnit(0.25f, TextUnitType.Sp)
                    )
                }
            }
        }
        Spacer(Modifier.fillMaxWidth().height(1.dp).background(BlackColor8))
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DailyWeatherStatusCardPreview() {
    DailyWeatherStatusCard(
        0 ,
        day = "Monday",
        maxTemperature = "30°C",
        minTemperature = "20°C"
    )
}