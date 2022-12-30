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
import com.example.chucknorrisapicompose.data.ThemeViewModel

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    val context = LocalContext.current
    val viewModel = remember { ThemeViewModel(context.dataStore) }
    val state = viewModel.state.observeAsState()
    val value = state.value ?: isSystemInDarkTheme()

    LaunchedEffect(viewModel) { viewModel.request() }

    DarkThemeValue.current.value = value
    MaterialTheme(
        colors = if (value) AppDarkColors else AppLightColors,
        typography = AppTypography,
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