package com.example.pillreminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.pillreminder.navigation.SetupNavigation
import com.example.pillreminder.presentation.screens.splash.SplashViewModel
import com.example.pillreminder.ui.theme.PillReminderTheme

class MainActivity : ComponentActivity() {
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition { viewModel.isLoading.value }
        setContent {
            PillReminderTheme {
                val navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}