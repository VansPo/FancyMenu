package com.ipvans.fancymenu

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Toast

class MainActivity : AppCompatActivity(), MenuCallbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menu = FancyMenu
                .with(this)
                .setMenuView(FancyMenuView(this, R.layout.menu_content))


        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.setNavigationIcon(R.drawable.ic_menu_24dp)
        toolbar.setNavigationOnClickListener { menu.show() }
    }


    override fun onMenuShown() {
        Toast.makeText(this, "menu shown", Toast.LENGTH_SHORT).show()
    }

    override fun onMenuHidden() {
        Toast.makeText(this, "menu hidden", Toast.LENGTH_SHORT).show()
    }
}