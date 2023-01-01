package com.example.chucknorrisapicompose.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

data class Joke(
    var icon_url: String,
    var id: String,
    var url: String,
    var value: String
)


data class JokeQueryResult(
    var total: String,
    var result: List<Joke>
)


const val BASE_URL = "https://api.chucknorris.io/jokes/"

interface APIService {
    @GET("random")
    suspend fun getJoke(): Joke

    @GET("random")
    suspend fun getCategoryJoke(@Query("category") text: String?): Joke

    @GET("search")
    suspend fun findJokes(@Query("query") text: String?): JokeQueryResult


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