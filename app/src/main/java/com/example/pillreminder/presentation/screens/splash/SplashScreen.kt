package com.example.pillreminder.presentation.screens.splash

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.pillreminder.R
import com.example.pillreminder.ui.theme.PillReminderTheme

//@Composable
//fun SplashScreen() {
//    val splashAnimation = rememberInfiniteTransition(label = "splash screen anim").animateFloat(
//        initialValue = 1f,
//        targetValue = 1.4f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(1000),
//            repeatMode = RepeatMode.Reverse
//        ), label = "pills anim"
//    )
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color = MaterialTheme.colorScheme.primary),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        Image(
//            modifier = Modifier.scale(splashAnimation.value),
//            painter = painterResource(id = R.drawable.pills_image),
//            contentDescription = "Pills icon"
//        )
//    }
//}
//
//@Composable
//@Preview
//fun SplashScreenPreview() {
//    PillReminderTheme {
//        SplashScreen()
//    }
//}