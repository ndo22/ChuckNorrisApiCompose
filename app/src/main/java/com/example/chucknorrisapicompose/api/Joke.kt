package com.example.chucknorrisapicompose.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Joke(
    var icon_url: String,
    var id: String,
    var url: String,
    var value: String
)

const val BASE_URL = "https://api.chucknorris.io/jokes/"

interface APIService {
    @GET("random")
    suspend fun getJoke(): Joke

    companion object {
        var apiService: APIService? = null
        fun getInstance(): APIService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIService::class.java)
            }
            return apiService!!
        }
    }
}