package com.senjapagi.kolaborasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.senjapagi.kolaborasi.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_login.*
import kotlinx.android.synthetic.main.layout_register.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnLogin.setOnClickListener {
            btnLogin.visibility = View.GONE
            progress_loading.visibility = View.VISIBLE
            val c = Handler()
            c.postDelayed({
                startActivity(Intent(this@MainActivity,user_landing::class.java))
                finish()
            }, 500)
        }

        btnCloseReg.setOnClickListener {
            lyt_register.apply {
                animation = AnimationUtils.loadAnimation(
                    context,
                    R.anim.item_animation_gone_bottom
                )
                visibility = View.GONE
            }
        }

        btnCloseLogin.setOnClickListener {
            lyt_login.apply {
                animation = AnimationUtils.loadAnimation(
                    context,
                    R.anim.item_animation_gone_bottom
                )
                visibility = View.GONE
            }
        }

        btnStartLogin.setOnClickListener {
            lyt_login.apply {
                visibility = View.VISIBLE
                animation = AnimationUtils.loadAnimation(
                    context, R.anim.item_animation_appear_bottom
                )
            }
        }

        btnStartRegister.setOnClickListener {
            lyt_register.apply {
                visibility = View.VISIBLE
                animation = AnimationUtils.loadAnimation(
                    context, R.anim.item_animation_appear_bottom
                )
            }
        }
    }
}