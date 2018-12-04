package com.example.pedro.drinks.utils

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout

//Código retirado do repositório https://github.com/tirgei/PocketBartender

class SquareLayout : RelativeLayout {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }

}