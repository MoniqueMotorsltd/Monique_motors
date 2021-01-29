package com.ex.moniquemotors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BookingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        val roundtrip_btn = findViewById(R.id.roundtrip_btn) as Button

        roundtrip_btn.setOnClickListener{
            startActivity(Intent(this,RoundTripActivity::class.java))
            finish()
        }
    }
}