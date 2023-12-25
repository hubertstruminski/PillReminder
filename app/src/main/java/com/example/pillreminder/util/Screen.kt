package com.example.pillreminder.util

sealed class Screen(val route: String) {
    object Login: Screen(route = "login_screen")
    object Register: Screen(route = "register_screen")
    object Home: Screen(route = "home_screen")
}
