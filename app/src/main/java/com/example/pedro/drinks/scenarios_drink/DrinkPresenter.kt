package com.example.pedro.drinks.scenarios_drink

import com.example.pedro.drinks.R
import com.example.pedro.drinks.R.id.*
import com.example.pedro.drinks.entities.Drink
import com.example.pedro.drinks.entities.DrinkList
import com.example.pedro.drinks.network.RetrofitInicializer
import com.example.pedro.drinks.utils.GlideApp
import kotlinx.android.synthetic.main.activity_drink.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DrinkPresenter(val view: DrinkContract.View) : DrinkContract.Presenter {

    override fun carregaDados(drinkP: Drink) {

        val drinkService = RetrofitInicializer().createDrinksService()

        var call = drinkService.byId(drinkP.idDrink)

        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                if (response.body() != null) {
                    val drink = response.body()!!.drinks[0]
                    view.showDrink(drink)
                } else {
                    view.showMessage("Falha na conexão. Verifique o acesso a internet")
                }
            }
        })
    }
}
