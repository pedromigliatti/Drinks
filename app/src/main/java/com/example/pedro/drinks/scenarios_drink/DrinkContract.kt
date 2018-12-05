package com.example.pedro.drinks.scenarios_drink

import android.widget.TextView
import com.example.pedro.drinks.entities.Drink

interface DrinkContract{

    interface View{
        fun showMessage(msg: String)
        fun showTextView(measure: TextView, ingre: TextView)
        fun showDrink(drink: Drink)
    }

    interface Presenter {
        fun carregaDados(drink: Drink)
    }

}