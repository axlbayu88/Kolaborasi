package com.senjapagi.kolaborasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_dashboard_user.*
import kotlinx.android.synthetic.main.activity_dashboard_user.btnToggleNavdraw
import kotlinx.android.synthetic.main.custom_navdraw.*
import kotlinx.android.synthetic.main.user_profile.*

class user_profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_profile)
        lyt_user_profile.background.alpha = 255

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

    }

    override fun onBackPressed() {
        NavDrawToggle("close")
        finish()
        startActivity(Intent(this@user_profile,user_landing::class.java))

    }

    fun NavDrawToggle(indicator: String) {
        if (indicator.equals("open")) {
            lyt_navdraw.visibility = View.VISIBLE
            lyt_navdraw.animation =
                AnimationUtils.loadAnimation(this, R.anim.fade_transition_animation)
            lyt_user_profile.background.alpha = 200
        } else {
            lyt_navdraw.animation =
                AnimationUtils.loadAnimation(this, R.anim.fade_transition_animation_go)
            lyt_navdraw.visibility = View.GONE
            lyt_user_profile.background.alpha = 255
        }

    }
}