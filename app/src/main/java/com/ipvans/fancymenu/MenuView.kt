package com.ipvans.fancymenu

import android.view.ViewGroup

abstract class MenuView(val layoutRes: Int) {

    lateinit var menu: FancyMenu
    val layout: ViewGroup by lazy { menu.context.layoutInflater.inflate(layoutRes, menu.root, false) as ViewGroup }

    abstract fun init()

}