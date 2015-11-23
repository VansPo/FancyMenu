package com.ipvans.fancymenu

class FancyMenuView(val context: MainActivity, layoutRes: Int) : MenuView(layoutRes), MenuCallbacks {

    override fun init() {
        layout.setOnClickListener { menu.hide() }
    }

    override fun onMenuShown() { }

    override fun onMenuHidden() { }

}