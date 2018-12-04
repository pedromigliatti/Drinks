package com.example.pedro.drinks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
        iba.text = drink.strIBA
        instructions.text = drink.strInstructions

        GlideApp.with(this)
                .load(drink.strDrinkThumb)
                .placeholder(R.drawable.no_image)
                .centerCrop()
                .into(imgFoto)
        
    }
}
