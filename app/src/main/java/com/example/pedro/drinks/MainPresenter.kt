package com.example.pedro.drinks

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: MainContract.View) : MainContract.Presenter {

    override fun onLoadList(type: Int) {

        view.showLoading()

        val drinkService = RetrofitInicializer().createDrinksService()

        var call = drinkService.alcoholic()

        when (type) {
            0 -> call = drinkService.alcoholic()
            1 -> call = drinkService.random()
            2 -> call = drinkService.nonAlcoholic()
        }

        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                view.hideLoading()
                if (response.body() != null) {
                    view.showList(response.body()!!.drinks)
                } else {
                    view.showMessage("Sem notícias para hoje")
                }
            }
        })
    }

}
