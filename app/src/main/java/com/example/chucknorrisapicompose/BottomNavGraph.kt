package com.example.chucknorrisapicompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chucknorrisapicompose.viewModels.JokeViewModel
import com.example.chucknorrisapicompose.viewModels.SearchViewModel
import com.example.chucknorrisapicompose.navigation.Screen
import com.example.chucknorrisapicompose.screens.AnimatedSplashScreen
import com.example.chucknorrisapicompose.screens.HomeScreen
import com.example.chucknorrisapicompose.screens.ProfileScreen
import com.example.chucknorrisapicompose.screens.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            AnimatedSplashScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(JokeViewModel())
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(SearchViewModel())
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
    }
}