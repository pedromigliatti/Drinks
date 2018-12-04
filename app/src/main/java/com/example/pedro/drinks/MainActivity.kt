package com.example.pedro.drinks

import android.content.Intent
import android.net.Uri
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View  {

    private var navigationView: BottomNavigationView? = null

    lateinit var toolbar: ActionBar

    val presenter : MainContract.Presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)


        presenter.onLoadList(0)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//
//        val d1 = Drink("13060",
//                "Margarita",
//                null,
//                "Ordinary Drink",
//                "Contemporary Classics",
//                "Alcoholic",
//                "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.",
//                "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg")
//
//        val d2 = Drink("13060",
//                "Margarita",
//                null,
//                "Ordinary Drink",
//                "Contemporary Classics",
//                "Alcoholic",
//                "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.",
//                "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg")
//
//        val d3 = Drink("13060",
//                "Margarita",
//                null,
//                "Ordinary Drink",
//                "Contemporary Classics",
//                "Alcoholic",
//                "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten only the outer rim and sprinkle the salt on it. The salt should present to the lips of the imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully pour into the glass.",
//                "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg")
//
//
//        val testList = listOf(d1, d2, d3)
//
//        showList(testList)
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
        adapter.setOnItemClickListener {position ->
            val openBrowser = Intent(Intent.ACTION_VIEW)
            openBrowser.data = Uri.parse(list.get(position).strDrinkThumb)
            startActivity(openBrowser)
        }

        rvDrinks?.setHasFixedSize(true)
        rvDrinks.adapter = adapter

        rvDrinks?.layoutManager = GridLayoutManager(this, 2)

        rvDrinks?.addItemDecoration(RecyclerFormatter.ItemSpacing(this, R.dimen.spacing))

    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        pbLoading.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = ProgressBar.INVISIBLE
    }
}

