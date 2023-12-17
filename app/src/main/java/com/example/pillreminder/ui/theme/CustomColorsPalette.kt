package com.example.pillreminder.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColorsPalette(
    val mediumBlack: Color = MediumBlack,
    val lightGray: Color = LightGray
)

val LightCustomColorsPalette = CustomColorsPalette(
    // specify custom theme colors
    // mediumBlack = Color.White
)
val DarkCustomColorsPalette = CustomColorsPalette()

val LocalCustomColorsPalette = staticCompositionLocalOf { CustomColorsPalette() }