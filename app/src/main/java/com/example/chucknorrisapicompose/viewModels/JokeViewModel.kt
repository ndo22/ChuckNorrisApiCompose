package com.example.chucknorrisapicompose.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorrisapicompose.api.APIService
import com.example.chucknorrisapicompose.api.Joke
import kotlinx.coroutines.async
import kotlinx.coroutines.launch



class JokeViewModel : ViewModel() {


    private val _joke = mutableStateOf<Joke?>(null)


    var errorMessage: String by mutableStateOf("")

    val joke: MutableState<Joke?> = _joke

    fun getRandomJoke(text : String) {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {
                val tmp = if (text == "all")
                    async {apiService.getJoke()}
                else
                    async {apiService.getCategoryJoke(text)}
                _joke.value = tmp.await()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}