package com.ex.moniquemotors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RoundTripActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_round_trip)

        val onetrip_btn = findViewById(R.id.onetrip_btn) as Button

        onetrip_btn.setOnClickListener{
            startActivity(Intent(this,BookingActivity::class.java))
            finish()
        }
    }
}