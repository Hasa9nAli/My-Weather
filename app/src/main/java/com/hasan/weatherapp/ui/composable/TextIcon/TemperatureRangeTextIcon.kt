package com.hasan.weatherapp.ui.composable.TextIcon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.hasan.weatherapp.R
import com.hasan.weatherapp.ui.theme.BlackColor8
import com.hasan.weatherapp.ui.theme.largeUnit
import com.hasan.weatherapp.ui.theme.smallUnit
import com.hasan.weatherapp.ui.theme.tinyUnit
import com.hasan.weatherapp.ui.theme.titleFontSize
import com.hasan.weatherapp.ui.theme.xSmallUnit

@Composable
fun TemperatureRangeTextIcon(
    minTemperature: String,
    maxTemperature: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier
            .background(BlackColor8, shape = RoundedCornerShape(100))
            .padding(vertical = smallUnit, horizontal = largeUnit),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(smallUnit)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                tinyUnit
            )
        ) {
            Icon(painter = painterResource(R.drawable.ic_arrow_down), null)
            Text(
                text = maxTemperature,
                fontSize = titleFontSize,
                fontWeight = FontWeight.Medium,
                letterSpacing = TextUnit(0.25f, TextUnitType.Sp)
            )
        }
        Spacer(
            modifier = modifier
                .height(xSmallUnit + tinyUnit)
                .width(1.dp)
                .background(Color(0x3D060414))
        )
        Row(

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                tinyUnit
            )
        ) {
            Icon(painter = painterResource(R.drawable.ic_arrow_down), null)
            Text(
                text = minTemperature,
                fontSize = titleFontSize,
                fontWeight = FontWeight.Normal,
                letterSpacing = TextUnit(0.25f, TextUnitType.Sp)
            )
        }
    }

}