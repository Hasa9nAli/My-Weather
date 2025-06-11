package com.hasan.weatherapp.presentation.ui.composable.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.hasan.weatherapp.presentation.ui.theme.WhiteColor8
import com.hasan.weatherapp.presentation.ui.theme.WhiteOrBlack60
import com.hasan.weatherapp.presentation.ui.theme.WhiteOrBlack70
import com.hasan.weatherapp.presentation.ui.theme.WhiteOrBlack8
import com.hasan.weatherapp.presentation.ui.theme.WhiteOrBlack87
import com.hasan.weatherapp.presentation.ui.theme.ellipse
import com.hasan.weatherapp.presentation.ui.theme.isNightTimeApproximate
import com.hasan.weatherapp.presentation.ui.theme.mediumFontSize
import com.hasan.weatherapp.presentation.ui.theme.mediumUnit
import com.hasan.weatherapp.presentation.ui.theme.tinyUnit
import com.hasan.weatherapp.presentation.ui.theme.xLargeUnit
import com.hasan.weatherapp.presentation.ui.theme.xSmallFontSize
import com.hasan.weatherapp.presentation.ui.theme.xSmallUnit
import com.skydoves.cloudy.cloudy

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
                .then(
                    if(isNightTimeApproximate())
                    Modifier.background(WhiteOrBlack70, shape = RoundedCornerShape(12.dp) )
                    else Modifier.background(
                            brush =
                                Brush.linearGradient(
                                    colors = listOf(
                                        Color(0x00FFFFFF), Color(0xFFFFFFFF)
                                    ),
                                    start = Offset(0f, 0f),
                                    end = Offset(0f, 1000f)
                                ),

                    )
                )

               .padding(horizontal = mediumUnit),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Text(
                modifier = Modifier.width(128.dp),
                text = day, fontSize = mediumFontSize,
                color = WhiteOrBlack60,
                fontWeight = FontWeight.Normal,
                letterSpacing = TextUnit(0.25f, TextUnitType.Sp)
            )
            Box(){
            if(isNightTimeApproximate())
            Image(
                painter = painterResource(ellipse),
                contentDescription = null,
                modifier = Modifier
                    .offset((-4).dp)
                    .size(xLargeUnit + tinyUnit + 2.dp)
                    .clip(CircleShape)
                    .cloudy(1000)
            )
                Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(xLargeUnit + tinyUnit + 2.dp)
            )
            }

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
                        tint = WhiteOrBlack87

                    )
                    Text(
                        text = maxTemperature,
                        fontSize = xSmallFontSize,
                        color = WhiteOrBlack87,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TextUnit(0.25f, TextUnitType.Sp)
                    )
                }
                Spacer(
                    modifier = Modifier.height(tinyUnit).width(1.dp).background(
                        if(isNightTimeApproximate())
                            WhiteColor8
                                    else
                        Color(0x05000000)
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_down),
                        null,
                        modifier = Modifier.size(xSmallUnit),
                        tint = WhiteOrBlack87

                    )
                    Text(
                        text = minTemperature,
                        fontSize = xSmallFontSize,
                        color = WhiteOrBlack87,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TextUnit(0.25f, TextUnitType.Sp)
                    )
                }
            }
        }
        Spacer(Modifier.fillMaxWidth().height(1.dp).background(WhiteOrBlack8))
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