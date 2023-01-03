package com.example.chucknorrisapicompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chucknorrisapicompose.api.JokeViewModel
import com.example.chucknorrisapicompose.ui.theme.backgroundColor
import com.example.chucknorrisapicompose.ui.theme.captionColor


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    viewModel: JokeViewModel
) {
    val joke = viewModel.joke.value
    var expanded by remember { mutableStateOf(false) }

    val options = listOf("all","animal","career","celebrity","dev","explicit","fashion","food","history","money","movie","music","political","religion","science","sport","travel")
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor())
    ) {

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                },
                modifier = Modifier.align(Alignment.TopCenter).padding(10.dp, 30.dp, 10.dp, 70.dp)
            ) {
                TextField(
                    readOnly = true,
                    value = selectedOptionText,
                    onValueChange = { getResponse(viewModel, selectedOptionText) },
                    label = { Text("Joke Category") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = expanded
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                    }
                ) {
                    options.forEach { selectionOption ->
                        DropdownMenuItem(
                            onClick = {
                                selectedOptionText = selectionOption
                                expanded = false
                            }
                        ) {
                            Text(text = selectionOption)
                        }
                    }
                }
            }

            Card(
                elevation = 10.dp, modifier = Modifier
                    .align(Alignment.Center)
                    .padding(20.dp)
            ) {
                Text(
                    text = joke?.value ?: "Place for your joke. Refresh",
                    fontSize = MaterialTheme.typography.h1.fontSize,
                    fontWeight = MaterialTheme.typography.h1.fontWeight,
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
                onClick = { getResponse(viewModel, selectedOptionText) },
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

fun getResponse(viewModel: JokeViewModel, text: String) {
    viewModel.getRandomJoke(text)
}

