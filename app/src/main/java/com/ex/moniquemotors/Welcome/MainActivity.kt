package com.ex.moniquemotors.Welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ex.moniquemotors.R

class MainActivity : AppCompatActivity() {

    private val TIME_OUT = 1700


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Handler().postDelayed(
            {
             startActivity(Intent(this, Intro_Slider::class.java))
                finish()
            },TIME_OUT.toLong())
    }
}