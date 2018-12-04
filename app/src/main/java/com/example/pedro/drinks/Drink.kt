package com.example.pedro.drinks

import java.io.Serializable

data class Drink(
        val idDrink: String,
        val strDrink: String,
        val strVideo: String?,
        val strCategory: String,
        val strIBA: String,
        val strAlcoholic: String,
        val strInstructions: String,
        val strDrinkThumb: String
) : Serializable