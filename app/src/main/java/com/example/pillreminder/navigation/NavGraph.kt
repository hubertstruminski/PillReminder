package com.example.pillreminder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pillreminder.presentation.screens.authorization.LoginScreen
import com.example.pillreminder.presentation.screens.authorization.RegisterScreen
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
        registerScreen(
            navigateToLogin = {
                navController.popBackStack()
                navController.navigate(Screen.Login.route)
            }
        )
    }
}

fun NavGraphBuilder.loginScreen(
    navigateToRegister: () -> Unit
) {
    composable(route = Screen.Login.route) {
        LoginScreen(navigateToRegister = navigateToRegister)
    }
}

fun NavGraphBuilder.registerScreen(
    navigateToLogin: () -> Unit
) {
    composable(route = Screen.Register.route) {
        RegisterScreen(navigateToLogin = navigateToLogin)
    }
}