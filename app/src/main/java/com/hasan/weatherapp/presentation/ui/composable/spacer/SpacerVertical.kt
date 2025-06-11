package com.hasan.weatherapp.presentation.ui.composable.spacer
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hasan.weatherapp.presentation.ui.theme.largeUnit
import com.hasan.weatherapp.presentation.ui.theme.mediumUnit
import com.hasan.weatherapp.presentation.ui.theme.smallUnit
import com.hasan.weatherapp.presentation.ui.theme.tinyUnit
import com.hasan.weatherapp.presentation.ui.theme.xLargeUnit
import com.hasan.weatherapp.presentation.ui.theme.xSmallUnit
import com.hasan.weatherapp.presentation.ui.theme.xxxLargeUnit

@Composable
fun SpacerVerticalTiny(){
    Spacer(modifier = Modifier.height(tinyUnit))
}

@Composable
fun SpacerVerticalSmall(){
    Spacer(modifier = Modifier.height(smallUnit))
}

@Composable
fun SpacerVerticalXSmall(){
    Spacer(modifier = Modifier.height(xSmallUnit))
}

@Composable
fun SpacerVerticalMedium(){
    Spacer(modifier = Modifier.height(mediumUnit))
}

@Composable
fun SpacerVerticalLarge(){
    Spacer(modifier = Modifier.height(largeUnit))
}
@Composable
fun SpacerVerticalXLarge(){
    Spacer(modifier = Modifier.height(xLargeUnit))
}

@Composable
fun SpacerVerticalXXXLarge(){
    Spacer(modifier = Modifier.height(xxxLargeUnit))
}