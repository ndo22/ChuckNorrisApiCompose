package com.example.chucknorrisapicompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chucknorrisapicompose.api.JokeViewModel
import com.example.chucknorrisapicompose.ui.theme.AppTypography
import com.example.chucknorrisapicompose.ui.theme.backgroundColor
import com.example.chucknorrisapicompose.ui.theme.captionColor


@Composable
fun HomeScreen(
    viewModel: JokeViewModel
) {
    val joke = viewModel.joke.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor()),
    ) {

        Card(elevation = 10.dp, modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(20.dp, 40.dp, 20.dp, 70.dp)) {
            Text(
                text = joke?.value ?: "Place for your joke. Refresh",
                fontSize = AppTypography.h1.fontSize,
                fontWeight = AppTypography.h1.fontWeight,
                color = captionColor(),
                modifier = Modifier.padding(10.dp),
            )
        }
//        Image(
//            painter = rememberAsyncImagePainter("http://stackoverflow.com/apple-touch-icon.png"),
//            contentDescription = "Image of chuck",
//            modifier = Modifier.size(128.dp).align(Alignment.Center)
//        )
        Button(
            onClick = { getResponse(viewModel) },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(10.dp, 10.dp, 10.dp, 70.dp)
        ) {
            Text("Refresh")
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(JokeViewModel())
}

fun getResponse(viewModel: JokeViewModel) {
    viewModel.getRandomJoke()
}

