package com.example.pillreminder

import android.content.Context
import android.os.Bundle
import android.util.Log
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
    private val viewModel: SplashViewModel by viewModels()

    @Inject
    lateinit var globalPreferences: GlobalPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition { viewModel.isLoading.value }
        setContent {
            PillReminderTheme {
                globalPreferences.preferences = getPreferences(Context.MODE_PRIVATE)
                Log.d("AT START", "onCreate: ${globalPreferences.preferences}")
                val navController = rememberNavController()
                SetupNavigation(navController = navController)
            }
        }
    }
}