//package com.example.pedro.drinks
//
//import android.os.Bundle
//import android.support.v4.app.Fragment
//import android.support.v7.widget.GridLayoutManager
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import kotlinx.android.synthetic.main.fragment_list.view.*
//
//class DrinkFragment : Fragment(),  {
//    private var drinkAdapter: DrinkAdapter? = null
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//
//        val v = inflater.inflate(R.layout.fragment_list, container, false)
////        cacheManager = CacheManager(activity!!)
//        return v
//
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        initViews(view)
//        loadCocktails(0)
//    }
//
//    private fun initViews(v: View) {
//
//        v.rvDrinks.setHasFixedSize(true)
//        v.rvDrinks?.layoutManager = GridLayoutManager(activity, 2)
//        v.rvDrinks?.addItemDecoration(RecyclerFormatter.ItemSpacing(activity!!, "5dp"))
//
//        drinks = mutableListOf()
//        drinkAdapter = DrinkAdapter(drinks  as ArrayList<HomeModel>) {loadDetails(it)}
//        v.rvDrinks?.adapter = homeAdapter!!
//        (activity as MainActivity).scrollRv(this)
//    }
//}