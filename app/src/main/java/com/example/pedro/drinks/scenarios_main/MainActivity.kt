package com.example.pedro.drinks.scenarios_main

import android.content.Intent
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.GridLayoutManager
import android.widget.ProgressBar
import android.widget.Toast
import com.example.pedro.drinks.R
import com.example.pedro.drinks.entities.Drink
import com.example.pedro.drinks.scenarios_drink.DrinkActivity
import com.example.pedro.drinks.scenarios_drink.DrinkAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private var navigationView: BottomNavigationView? = null

    lateinit var toolbar: ActionBar

    val presenter : MainContract.Presenter = MainPresenter(this)

    var indexDrinkClicado: Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)


        presenter.onLoadList(0)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_alcoholic -> {
                presenter.onLoadList(0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_random -> {
                presenter.onLoadList(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_alfabetic -> {
                presenter.onLoadList(2)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun showList(list: List<Drink>) {

        val adapter = DrinkAdapter(this, list)
        adapter.setOnItemClickListener {drink, indexDrinkClicado ->
            this.indexDrinkClicado = indexDrinkClicado
            val detalheDrink = Intent(this, DrinkActivity::class.java)
            detalheDrink.putExtra("Drink", drink)
            this.startActivityForResult(detalheDrink, 1)
        }

        rvDrinks?.setHasFixedSize(true)
        rvDrinks.adapter = adapter

        rvDrinks?.layoutManager = GridLayoutManager(this, 2)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        pbLoading.visibility = ProgressBar.VISIBLE
    }

    override fun hideRv(){
        rvDrinks.visibility = ProgressBar.INVISIBLE
    }

    override fun showRv(){
        rvDrinks.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = ProgressBar.INVISIBLE
    }
}

