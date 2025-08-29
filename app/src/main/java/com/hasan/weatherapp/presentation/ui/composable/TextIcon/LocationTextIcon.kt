package com.hasan.weatherapp.presentation.ui.composable.TextIcon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.hasan.weatherapp.R
import com.hasan.weatherapp.presentation.ui.theme.PrimaryTextColor
import com.hasan.weatherapp.presentation.ui.theme.largeUnit
import com.hasan.weatherapp.presentation.ui.theme.mediumFontSize
import com.hasan.weatherapp.presentation.ui.theme.tinyUnit

@Composable
fun LocationTextIcon(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Icon(painter =
            painterResource(R.drawable.ic_location),
            null,
            tint = PrimaryTextColor,
            modifier = Modifier.size(largeUnit).padding(end = tinyUnit)
            )
    Text(
        text= text,
        fontSize = mediumFontSize,
        color = PrimaryTextColor,
        fontWeight = FontWeight.Medium,

    )
    }

}