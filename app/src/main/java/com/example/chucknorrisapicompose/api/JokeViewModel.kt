package com.example.chucknorrisapicompose.api

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch



class JokeViewModel : ViewModel() {


    private val _joke = mutableStateOf<Joke?>(null)


    var errorMessage: String by mutableStateOf("")

    val joke: MutableState<Joke?> = _joke

    fun getRandomJoke() {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {
                var tmp = async {apiService.getJoke()}
                _joke.value = tmp.await()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}