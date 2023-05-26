package com.frt.cardsuits.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Blue = Color(0xFF96B0E4)
val LightBlue = Color(0xFFD2DDF3)
val Background = Color(0xFFF0F6FE)
val ScoreTextColor = Color(0xFFF2F2F2)
val Blue2 = Color(0xFF96B0E4)
val BlueLight2 = Color(0xFFD2DDF3)
val BlueLight3 = Color(0xFFD2DDF3)
val BlueLight4 = Color(0xFF96B0E4)
val BlueLight5 = Color(0xFFD2DDF3)

val DisableLanguageBack = Brush.verticalGradient(
    listOf(
        BlueLight4.copy(alpha = 0.5f),
        BlueLight5.copy(alpha = 0.495f)
    )
)

val EnableLanguageBack = Brush.verticalGradient(
    listOf(
        BlueLight4,
        BlueLight5.copy(alpha = 0.99f)
    )
)

val MenuButtonGradient = Brush.verticalGradient(
    listOf(
        Blue,
        LightBlue.copy(alpha = 0.99f)
    )
)

val GameGradient = Brush.verticalGradient(
    listOf(
        Blue2,
        BlueLight2.copy(alpha = 0.99f)
    )
)


val ScoreGradient = Brush.verticalGradient(
    listOf(
        Blue2,
        BlueLight3.copy(alpha = 0.99f)
    )
)