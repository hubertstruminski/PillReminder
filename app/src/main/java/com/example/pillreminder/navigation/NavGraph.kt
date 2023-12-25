package com.example.pillreminder.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pillreminder.presentation.screens.authorization.LoginScreen
import com.example.pillreminder.util.Screen

@Composable
fun SetupNavigation(
    navController: NavHostController,
) {
    NavHost(startDestination = Screen.Login.route, navController = navController) {
        loginScreen(
            navigateToRegister = {
                navController.navigate(Screen.Register.route)
            }
        )
        registerScreen()
    }
}

fun NavGraphBuilder.loginScreen(
    navigateToRegister: () -> Unit
) {
    composable(route = Screen.Login.route) {
        LoginScreen(navigateToRegister = navigateToRegister)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.registerScreen() {
    composable(route = Screen.Register.route) {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = it.calculateTopPadding()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Register Screen")
            }
        }
    }
}