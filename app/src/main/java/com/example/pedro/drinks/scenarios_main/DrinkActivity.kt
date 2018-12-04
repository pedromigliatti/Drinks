package com.example.pedro.drinks.scenarios_main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.pedro.drinks.entities.Drink
import com.example.pedro.drinks.utils.GlideApp
import com.example.pedro.drinks.R
import kotlinx.android.synthetic.main.activity_drink.*

class DrinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)

        val drink: Drink? = intent.getSerializableExtra("Drink") as Drink?
        if(drink != null){
            carregaDados(drink)
        }
    
    }

    private fun carregaDados(drink: Drink) {
        codigo.text = drink.idDrink
        nome.text = drink.strDrink
        alcoholic.text = drink.strAlcoholic
        categoria.text = drink.strCategory
        glass.text = drink.strGlass
        instructions.text = drink.strInstructions
        measure1.text = drink.strMeasure1
        ingre1.text = drink.strIngredient1

        measure2.text = drink.strMeasure2
        ingre2.text = drink.strIngredient2

        measure3.text = drink.strMeasure3
        ingre3.text = drink.strIngredient3

        measure4.text = drink.strMeasure4
        ingre4.text = drink.strIngredient4

        measure4.text = drink.strMeasure4
        ingre4.text = drink.strIngredient4

        measure5.text = drink.strMeasure5
        ingre5.text = drink.strIngredient5

        measure6.text = drink.strMeasure6
        ingre6.text = drink.strIngredient6

        measure7.text = drink.strMeasure7
        ingre7.text = drink.strIngredient7

        measure8.text = drink.strMeasure9
        ingre8.text = drink.strIngredient9

        measure10.text = drink.strMeasure10
        ingre10.text = drink.strIngredient10

        measure11.text = drink.strMeasure11
        ingre11.text = drink.strIngredient11

        measure12.text = drink.strMeasure12
        ingre12.text = drink.strIngredient12

        measure13.text = drink.strMeasure13
        ingre13.text = drink.strIngredient13

        measure14.text = drink.strMeasure14
        ingre14.text = drink.strIngredient14

        measure15.text = drink.strMeasure15
        ingre15.text = drink.strIngredient15

        GlideApp.with(this)
                .load(drink.strDrinkThumb)
                .placeholder(R.drawable.no_image)
                .centerCrop()
                .into(imgFoto)
        
    }
}
