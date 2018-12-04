package com.example.pedro.drinks

interface MainContract {

    interface View{
        fun showMessage(msg: String)
        fun showList(articles: List<Drink>)
        fun showLoading()
        fun hideLoading()
        fun showRv()
        fun hideRv()
    }

    interface Presenter {
        fun onLoadList(type: Int)
    }

}