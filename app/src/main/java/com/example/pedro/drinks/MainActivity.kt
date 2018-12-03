package com.example.pedro.drinks

import android.content.Intent
import android.net.Uri
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var navigationView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView = findViewById<View>(R.id.navigationView) as BottomNavigationView?

        val d1 = Drink("13060",
                "Margarita",
                null,
                "Ordinary Drink",
                "Contemporary Classics",
                "Alcoholic",
                "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.",
                "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg")

        val d2 = Drink("13060",
                "Margarita",
                null,
                "Ordinary Drink",
                "Contemporary Classics",
                "Alcoholic",
                "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.",
                "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg")


        val testList = listOf(d1, d2)

        exibeLista(testList)
    }

    fun exibeLista(list: List<Drink>) {

        val adapter = DrinkAdapter(this, list)
        adapter.setOnItemClickListener {position ->
            val openBrowser = Intent(Intent.ACTION_VIEW)
            openBrowser.data = Uri.parse(list.get(position).strDrinkThumb)
            startActivity(openBrowser)
        }

        rvDrinks.adapter = adapter
        rvDrinks.layoutManager = LinearLayoutManager(this)
    }
}
