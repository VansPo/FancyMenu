package com.ipvans.fancymenu

import android.app.Activity
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import jp.wasabeef.blurry.Blurry

class FancyMenu {

    lateinit var context: Activity
    lateinit var menuView: MenuView
    val root: ViewGroup by lazy { context.findViewById(android.R.id.content) as ViewGroup }
    private val content: ViewGroup by lazy { context.findViewById(R.id.root) as ViewGroup }

    private val menuSubscribers = listOf<MenuCallbacks>()

    companion object {

        fun with(context: Activity): FancyMenu {
            val menu = FancyMenu(context)
            return menu
        }
    }

    private constructor(context: Activity) {
        this.context = context
    }

    fun setMenuView(menuView: MenuView): FancyMenu {
        this.menuView = menuView
        menuView.menu = this
        menuView.init()
        return this
    }

    fun show() {
        startShowAnimation()
        menuSubscribers.forEach { it.onMenuShown() }
    }

    fun hide() {
        startHideAnimation()
        menuSubscribers.forEach { it.onMenuHidden() }
    }

    private fun startShowAnimation() {
        val contentAnimator = content.animate();
        contentAnimator.scaleX(0.8f).scaleY(0.8f);
        contentAnimator.setDuration(500);
        contentAnimator.setInterpolator(OvershootInterpolator());
        contentAnimator.start();

        root.addView(menuView.layout)

        val menuAnimator = menuView.layout.animate();
        menuAnimator.alpha(1f);
        menuAnimator.setDuration(500);
        menuAnimator.start();
    }

    private fun startHideAnimation() {
        val animator = content.animate();
        animator.scaleX(1f).scaleY(1f);
        animator.setDuration(500);
        animator.setInterpolator(OvershootInterpolator())
        animator.start();

        root.removeView(menuView.layout)
        val menuAnimator = menuView.layout.animate();
        menuAnimator.alpha(0f);
        menuAnimator.setDuration(500);
        menuAnimator.start();
    }

}