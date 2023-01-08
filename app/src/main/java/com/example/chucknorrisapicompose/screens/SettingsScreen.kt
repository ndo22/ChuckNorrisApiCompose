package com.example.chucknorrisapicompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.chucknorrisapicompose.viewModels.ThemeViewModel
import com.example.chucknorrisapicompose.ui.theme.Caption
import com.example.chucknorrisapicompose.ui.theme.backgroundColor
import com.example.chucknorrisapicompose.ui.theme.captionColor
import com.example.chucknorrisapicompose.ui.theme.dataStore

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingsScreen() {
    val context = LocalContext.current
    val viewModel = remember {
        ThemeViewModel(context.dataStore)
    }

    val value = viewModel.state.observeAsState().value
    val font  = viewModel.font.observeAsState().value
    val systemInDarkTheme = isSystemInDarkTheme()


    var expanded by remember { mutableStateOf(false) }
    val options = listOf("small","medium","large")

    val darkModeChecked by remember(value) {
        val checked = when (value) {
            null -> systemInDarkTheme
            else -> value
        }
        mutableStateOf(checked)
    }
    val useDeviceModeChecked by remember(value) {
        val checked = when (value) {
            null -> true
            else -> false
        }
        mutableStateOf(checked)
    }

    LaunchedEffect(viewModel) {
        viewModel.request()
    }

    val selectedOptionText by remember(font) {
        val checked = when (font) {
            "small" -> "small"
            "large" -> "large"
            else -> "medium"
        }
        mutableStateOf(checked)
    }

    //var selectedOptionText by remember { if (font != null) mutableStateOf(font) else mutableStateOf("medium") }

    Box(
        modifier = Modifier
            .background(backgroundColor())
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(40.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Row {
                Caption(
                    text = "\uD83C\uDF19  Dark mode",
                    color = captionColor(),
                    modifier = Modifier.weight(1f),
                    iconSize = 25.dp,
                )
                Switch(
                    checked = darkModeChecked,
                    onCheckedChange = { viewModel.switchToUseDarkMode(it) })
            }
            Row {
                Caption(
                    text = "\uD83D\uDCF1  Use device settings",
                    color = captionColor(),
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = useDeviceModeChecked,
                    onCheckedChange = { viewModel.switchToUseSystemSettings(it) })
            }
            Row {


            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                },
                modifier = Modifier
                    .padding(10.dp, 30.dp, 10.dp, 70.dp)
            ) {
                TextField(
                    readOnly = true,
                    value = selectedOptionText,
                    onValueChange = { viewModel.switchFontSettings(selectedOptionText) },
                    label = { Text("Text size") },
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
                                viewModel.switchFontSettings(selectionOption)
                                expanded = false
                            }
                        ) {
                            Text(text = selectionOption)
                        }
                    }
                }
            }

            }
        }
    }
}