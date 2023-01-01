package com.example.chucknorrisapicompose.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.chucknorrisapicompose.BottomBarScreen
import com.example.chucknorrisapicompose.R
import com.example.chucknorrisapicompose.ui.theme.orInLightTheme
import com.example.chucknorrisapicompose.ui.theme.splashBackgroundColor
import kotlinx.coroutines.delay


@Composable
fun AnimatedSplashScreen(navController: NavHostController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000,
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(route = BottomBarScreen.Home.route)
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(splashBackgroundColor())
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(painter = painterResource(id = R.drawable.chucknegative orInLightTheme R.drawable.chuck), contentDescription = "Image of chuck")

    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash(alpha = 1f)
}

@Composable
@Preview
fun SplashScreenDarkPreview() {
    Splash(alpha = 1f)
}