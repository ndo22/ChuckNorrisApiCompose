package com.example.chucknorrisapicompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.example.chucknorrisapicompose.viewModels.SearchViewModel
import com.example.chucknorrisapicompose.ui.theme.AppTypography
import com.example.chucknorrisapicompose.ui.theme.backgroundColor
import com.example.chucknorrisapicompose.ui.theme.captionColor

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ProfileScreen(
    viewModel: SearchViewModel
) {
    val numberOfJokes = viewModel.jokes.value?.total
    val jokes = viewModel.jokes.value?.result
    var text by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor()),
    ) {
        Column(modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(10.dp, 10.dp, 10.dp, 70.dp)) {

            Row(modifier = Modifier.fillMaxWidth().padding(10.dp)) {

                TextField(
                    value = text,
                    onValueChange = { text = it }
                )
                IconButton(onClick = { getResponses(viewModel, text)
                                     keyboardController?.hide()
                                     },
                    modifier = Modifier
                        .padding(10.dp)) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "search button")
                }
            }


            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = if (numberOfJokes == null) "For searching jokes insert your desired text into text field above" else "found $numberOfJokes jokes",
                    fontSize = AppTypography.body1.fontSize,
                    fontWeight = AppTypography.body1.fontWeight,
                    color = captionColor(),
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.CenterHorizontally),
                )

                jokes?.forEach { joke ->
                    Card(
                        elevation = 10.dp, modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = joke.value,
                            fontSize = MaterialTheme.typography.h1.fontSize,
                            fontWeight = MaterialTheme.typography.h1.fontWeight,
                            color = captionColor(),
                            modifier = Modifier.padding(10.dp),
                        )
                    }
                }
            }
        }
    }
}


fun getResponses(viewModel: SearchViewModel, text : String) {
    if (text.length>2)
        viewModel.findJokes(text)
}