package com.example.pillreminder.ui.theme

import androidx.compose.ui.graphics.Color

val Primary = Color.fromHex("50C6C7")
val Danger = Color.fromHex("B21345")
val White = Color.White
val MediumBlack = Color.fromHex("333333")
val LightGray = Color.fromHex("848484")

fun Color.Companion.fromHex(colorString: String) = Color(android.graphics.Color.parseColor("#$colorString"))