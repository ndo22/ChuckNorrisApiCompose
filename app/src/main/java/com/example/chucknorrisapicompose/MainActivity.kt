package com.example.chucknorrisapicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.chucknorrisapicompose.ui.theme.ChuckNorrisApiComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChuckNorrisApiComposeTheme {
                MainScreen()
            }
        }
    }
}