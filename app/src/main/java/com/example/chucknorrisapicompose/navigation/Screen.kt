package com.example.chucknorrisapicompose.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
}