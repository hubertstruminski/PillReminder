package com.example.pillreminder.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pillreminder.presentation.screens.authorization.LoginScreen
import com.example.pillreminder.presentation.screens.authorization.LoginViewModel
import com.example.pillreminder.presentation.screens.authorization.RegisterScreen
import com.example.pillreminder.presentation.screens.home.HomeScreen
import com.example.pillreminder.util.Screen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavigation(
    navController: NavHostController,
    startDestination: () -> String,
) {
    NavHost(startDestination = startDestination(), navController = navController) {
        loginScreen(
            navigateToRegister = {
                navController.navigate(Screen.Register.route)
            },
            navigateToHome = {
                navController.navigate(Screen.Home.route)
            }
        )
        registerScreen(
            navigateToLogin = {
                navController.popBackStack()
                navController.navigate(Screen.Login.route)
            }
        )
        homeScreen(
            navigateToLogin = {
                navController.popBackStack()
                navController.navigate(Screen.Login.route)
            }
        )
    }
}

fun NavGraphBuilder.loginScreen(
    navigateToRegister: () -> Unit,
    navigateToHome: () -> Unit
) {
    composable(route = Screen.Login.route) {
        val viewModel: LoginViewModel = hiltViewModel()

        LoginScreen(
            navigateToRegister = navigateToRegister,
            logIn = { email, password -> viewModel.logIn(email, password) },
            isLoading = viewModel.isLoading,
            navigateToHome = navigateToHome,
            canLogin = viewModel.canLogin,
            onRememberMeChange = { viewModel.rememberUserLogin(it) },
            initRememberMeCheckbox = { viewModel.initRememberMeCheckbox(it) }
        )
    }
}

fun NavGraphBuilder.registerScreen(
    navigateToLogin: () -> Unit
) {
    composable(route = Screen.Register.route) {
        val loginViewModel: LoginViewModel = hiltViewModel()

        RegisterScreen(
            navigateToLogin = navigateToLogin,
            onRememberMeChange = { loginViewModel.rememberUserLogin(it) }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.homeScreen(navigateToLogin: () -> Unit) {
    composable(route = Screen.Home.route) {
        val loginViewModel: LoginViewModel = hiltViewModel()
        HomeScreen(
            logout = {
                loginViewModel.logout()
                navigateToLogin()
            }
        )
    }
}