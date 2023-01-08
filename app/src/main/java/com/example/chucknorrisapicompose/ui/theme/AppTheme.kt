package com.example.chucknorrisapicompose.ui.theme

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.chucknorrisapicompose.viewModels.ThemeViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    val context = LocalContext.current
    val viewModel = remember { ThemeViewModel(context.dataStore) }
    val state = viewModel.state.observeAsState()
    val font = viewModel.font.observeAsState()

    var test = isSystemInDarkTheme()

    val value = if (state.value != null) state.value else test
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = topBarColor())

    LaunchedEffect(viewModel) { viewModel.request() }

    if (value != null) {
        DarkThemeValue.current.value = value
    }



    MaterialTheme(
        colors = if (value == true) AppDarkColors else AppLightColors,
        typography = if(font.value == "small") AppSmallTypography else if(font.value == "large") AppLargeTypography else AppTypography,
        shapes = AppShapes,
        content = content
    )
}

@Composable
@ReadOnlyComposable
fun isDarkTheme() = DarkThemeValue.current.value

@SuppressLint("CompositionLocalNaming")
private val DarkThemeValue = compositionLocalOf { mutableStateOf(false) }

@Composable
@ReadOnlyComposable
infix fun <T> T.orInLightTheme(other: T): T = if (isDarkTheme()) this else other