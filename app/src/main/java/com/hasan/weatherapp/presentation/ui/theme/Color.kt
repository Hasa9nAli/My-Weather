package com.hasan.weatherapp.presentation.ui.theme

import androidx.compose.ui.graphics.Color
import com.hasan.weatherapp.R
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

val PrimaryColor = Color(0xFF87CEFA)
val PrimaryColor80 = Color(0xCC87CEFA)
val PrimaryColor60 = Color(0x9987CEFA)

val DarkPrimary = Color(0xFF7E2FFF)
val DarkPrimary80 = Color(0xFF7E2FFF)
val DarkSecondaryColor = Color(0xFFD4C0FF)

val BlackBold = Color(0xFF323232)
val BlackColor = Color(0xFF060414)
val BlackColor87 = Color(0xDE060414)
val BlackColor80 = Color(0xCC060414)
val BlackColor70 = Color(0xB3060414)
val BlackColor60 = Color(0x99060414)
val BlackColor8 = Color(0x14060414)

val WhiteColor = Color(0xFFFFFFFF)
val WhiteColor87 = Color(0xDEFFFFFF)
val WhiteColor80 = Color(0xCCFFFFFF)
val WhiteColor70 = Color(0xB3FFFFFF)
val WhiteColor60 = Color(0x99FFFFFF)
val WhiteColor8 = Color(0x14FFFFFF)

val PrimaryTextColor = if(isNightTimeApproximate()) Color(0xFFFFFFFF) else BlackBold
val PrimarySubTextColor = if(isNightTimeApproximate()) Color(0x99FFFFFF) else BlackColor60
val WhiteOrBlack8 = if(isNightTimeApproximate()) WhiteColor8 else BlackColor8
val WhiteOrBlack87 = if(isNightTimeApproximate()) WhiteColor87 else BlackColor87
val WhiteOrBlack70 = if(isNightTimeApproximate())   BlackColor70 else WhiteColor70
val WhiteOrBlack60 = if(isNightTimeApproximate()) WhiteColor60 else BlackColor60
val WhiteOrBlackZero = if(isNightTimeApproximate()) Color(0x00FFFFFF) else BlackColor

val TopGradientColor = if(isNightTimeApproximate())Color(0xFF060414) else Color(0xFF87CEFA)
val BottomGradientColor = if(isNightTimeApproximate())Color(0xFF060414) else Color(0x00FFFFFF)

fun isNightTimeApproximate(): Boolean {
    val currentTime = kotlinx.datetime.Clock.System.now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .time
    val nightStart = LocalTime(18, 0)
    val nightEnd = LocalTime(6, 0)
    return (currentTime > nightStart || currentTime < nightEnd)
}


val ellipse = if(isNightTimeApproximate()) R.drawable.ic_night_ellipse else R.drawable.ic_light_ellipse