package com.example.pedro.drinks.network

import com.example.pedro.drinks.entities.DrinkList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksService {

    companion object {
        private const val API_KEY = "1"
    }

    @GET("filter.php")
    fun alcoholic(@Query("a") country: String = "Alcoholic"): Call<DrinkList>

    @GET("filter.php")
    fun nonAlcoholic(@Query("a") country: String = "Non_Alcoholic"): Call<DrinkList>

    @GET("random.php")
    fun random(): Call<DrinkList>

}