package com.senjapagi.kolaborasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.AnimationUtils.loadAnimation
import kotlinx.android.synthetic.main.activity_dashboard_user.*
import kotlinx.android.synthetic.main.activity_dashboard_user.btnToggleNavdraw
import kotlinx.android.synthetic.main.custom_navdraw.*
import kotlinx.android.synthetic.main.user_profile.*

class user_landing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_user)
        lyt_navdraw.visibility = View.GONE


        btnToggleNavdraw.setOnClickListener {
            NavDrawToggle("open")
        }

        btnCloseNavDraw.setOnClickListener {
            NavDrawToggle("close")
        }

        lyt_navdraw_shadow.setOnClickListener {
            NavDrawToggle("close")
        }

        ndBtnProfile.setOnClickListener {
            NavDrawToggle("close")
            startActivity(Intent(this@user_landing, user_profile::class.java))
        }

        btnTextProfile.setOnClickListener {
            NavDrawToggle("close")
            startActivity(Intent(this@user_landing, user_profile::class.java))
        }
    }

    fun NavDrawToggle(indicator: String) {
        if (indicator.equals("open")) {
            lyt_navdraw.visibility = View.VISIBLE
            lyt_navdraw.animation =
                AnimationUtils.loadAnimation(this, R.anim.fade_transition_animation)
            lyt_landing_user.background.alpha = 200
        } else {
            lyt_navdraw.animation =
                AnimationUtils.loadAnimation(this, R.anim.fade_transition_animation_go)
            lyt_navdraw.visibility = View.GONE
            lyt_landing_user.background.alpha = 255
        }

    }

}