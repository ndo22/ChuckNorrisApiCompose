package com.example.chucknorrisapicompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.chucknorrisapicompose.api.JokeViewModel


@Composable
fun HomeScreen(
    viewModel: JokeViewModel
) {
    val joke = viewModel.joke.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta),
        contentAlignment = Alignment.Center
    ) {
        Column() {

            Text(
                text = joke?.value ?: "404 Joke not found",
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                )
            Button(onClick = { getResponse(viewModel) }) {
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(JokeViewModel())
}

fun getResponse(viewModel: JokeViewModel){
    var res = viewModel.getRandomJoke()
}

