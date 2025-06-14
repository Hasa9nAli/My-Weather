package com.hasan.weatherapp.presentation.ui.composable.spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hasan.weatherapp.presentation.ui.theme.largeUnit
import com.hasan.weatherapp.presentation.ui.theme.mediumUnit
import com.hasan.weatherapp.presentation.ui.theme.smallUnit
import com.hasan.weatherapp.presentation.ui.theme.tinyUnit
import com.hasan.weatherapp.presentation.ui.theme.xLargeUnit

@Composable
fun SpacerHorizontalTiny(){
    Spacer(modifier = Modifier.width(tinyUnit))
}

@Composable
fun SpacerHorizontalSmall(){
    Spacer(modifier = Modifier.width(smallUnit))
}
@Composable
fun SpacerHorizontalMedium(){
    Spacer(modifier = Modifier.width(mediumUnit))
}

@Composable
fun SpacerHorizontalLarge(){
    Spacer(modifier = Modifier.width(largeUnit))
}

@Composable
fun SpacerHorizontalXLarge(){
    Spacer(modifier = Modifier.width(xLargeUnit))
}
