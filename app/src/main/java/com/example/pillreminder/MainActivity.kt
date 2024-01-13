package com.example.pillreminder

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.pillreminder.navigation.SetupNavigation
import com.example.pillreminder.presentation.screens.splash.SplashViewModel
import com.example.pillreminder.storage.GlobalPreferences
import com.example.pillreminder.ui.theme.PillReminderTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var globalPreferences: GlobalPreferences

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        globalPreferences.preferences = getPreferences(Context.MODE_PRIVATE)
        installSplashScreen().setKeepOnScreenCondition { viewModel.isLoading.value }
        setContent {
            PillReminderTheme {
                val navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}