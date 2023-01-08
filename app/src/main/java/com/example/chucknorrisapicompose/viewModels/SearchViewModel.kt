package com.example.chucknorrisapicompose.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorrisapicompose.api.APIService
import com.example.chucknorrisapicompose.api.JokeQueryResult
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val _jokes = mutableStateOf<JokeQueryResult?>(null)

    var errorMessage: String by mutableStateOf("")

    var jokes: MutableState<JokeQueryResult?> = _jokes

    fun findJokes(text : String) {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {
                val tmp = async {apiService.findJokes(text)}
                _jokes.value = tmp.await()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}