package com.example.pedro.drinks.scenarios_main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
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

        showTextView(measure1, ingre1, drink)
        showTextView(measure2, ingre2, drink)
        showTextView(measure3, ingre3, drink)
        showTextView(measure4, ingre4, drink)
        showTextView(measure5, ingre5, drink)
        showTextView(measure6, ingre6, drink)
        showTextView(measure7, ingre7, drink)
        showTextView(measure8, ingre8, drink)
        showTextView(measure9, ingre9, drink)
        showTextView(measure10, ingre10, drink)
        showTextView(measure11, ingre11, drink)
        showTextView(measure12, ingre12, drink)
        showTextView(measure13, ingre13, drink)
        showTextView(measure14, ingre14, drink)
        showTextView(measure15, ingre15, drink)

        GlideApp.with(this)
                .load(drink.strDrinkThumb)
                .placeholder(R.drawable.no_image)
                .centerCrop()
                .into(imgFoto)
        
    }

    private fun showTextView(measure: TextView, ingre: TextView, drink: Drink){
        if(ingre.text.isEmpty()){
            ingre.visibility = View.GONE
            measure.visibility = View.GONE
        } else {
            ingre.visibility = View.VISIBLE
            measure.visibility = View.VISIBLE
            measure.text = drink.strMeasure1
            ingre.text = drink.strIngredient1
        }
    }
}


