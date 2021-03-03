package com.ex.moniquemotors.Book

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.ex.moniquemotors.Drawer.DashBoard
import com.ex.moniquemotors.R

class BookingActivity : AppCompatActivity() {


    override fun onBackPressed() {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        val backBtn = findViewById<ImageButton>(R.id.buttonBack)


        backBtn.setOnClickListener {
            startActivity(Intent(this,DashBoard::class.java))
            finish()
        }

        val fragment = OneWayTrip()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentView,fragment)
        transaction.commit()

        }
}