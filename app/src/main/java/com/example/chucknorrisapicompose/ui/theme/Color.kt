package com.example.chucknorrisapicompose.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Red = Color.fromRGB("#FF7C74")
val DarkRed = Color.fromRGB("#E65353")
val DarkBlue = Color.fromRGB("#0B1729")
val LightBlue = Color.fromRGB("#22416F")
val Silver20 = Color.fromRGB("#E5E5E5")
val SilverLight = Color.fromRGB("#F8F7F8")
val White = Color.fromRGB("#FFFFFF")
val Black = Color.fromRGB("#000000")

@Composable
fun backgroundColor() = DarkBlue orInLightTheme SilverLight

@Composable
fun splashBackgroundColor() = Black orInLightTheme White

@Composable
fun captionColor() = Silver20 orInLightTheme DarkBlue

@Composable
fun topBarColor() = LightBlue orInLightTheme DarkRed

private fun Color.Companion.fromRGB(rgb: String) = Color(android.graphics.Color.parseColor(rgb))

@SuppressLint("ConflictingOnColor")
val AppLightColors = lightColors(
    primary = Red,
    secondary = DarkBlue,
    background = White,
    surface = White,
    onPrimary = White,
    onBackground = DarkBlue,
    onSecondary = White,
)

@SuppressLint("ConflictingOnColor")
val AppDarkColors = darkColors(
    primary = Silver20,
    secondary = White,
    background = DarkBlue,
    surface = DarkBlue,
    onPrimary = DarkBlue,
    onBackground = Silver20,
    onSecondary = DarkBlue,
)