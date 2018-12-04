package com.example.pedro.drinks

interface MainContract {

    interface View{
        fun showMessage(msg: String)
        fun showList(articles: List<Drink>)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun onLoadList(type: Int)
    }

}