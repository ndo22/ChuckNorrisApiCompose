package com.example.chucknorrisapicompose.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ThemeViewModel(
    private val dataStore: DataStore<Preferences>
) : ViewModel() {

    private val forceDarkModeKey = booleanPreferencesKey("theme")
    val state = MutableLiveData<Boolean?>(null)

    private val fontKey = stringPreferencesKey("font")
    val font = MutableLiveData<String?>(null)

    fun request() {
        viewModelScope.launch {
            dataStore.data.collectLatest {
                state.value = it[forceDarkModeKey]
                font.value = it[fontKey]
            }
        }
    }

    fun switchToUseSystemSettings(isSystemSettings: Boolean) {
        viewModelScope.launch {
            if (isSystemSettings) {
                dataStore.edit {
                    it.remove(forceDarkModeKey)
                }
            }
        }
    }

    fun switchToUseDarkMode(isDarkTheme: Boolean) {
        viewModelScope.launch {
            dataStore.edit {
                it[forceDarkModeKey] = isDarkTheme
            }
        }
    }

    fun switchFontSettings(size: String) {
        viewModelScope.launch {
            if (size != null) {
                dataStore.edit {
                    it[fontKey] = size
                }
            }
        }
    }

}