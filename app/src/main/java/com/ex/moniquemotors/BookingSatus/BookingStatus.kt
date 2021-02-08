package com.ex.moniquemotors.BookingSatus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatImageView
import com.ex.moniquemotors.Drawer.DashBoard
import com.ex.moniquemotors.R

class BookingStatus : AppCompatActivity() {

    lateinit var tv_back:ImageButton
    lateinit var search:AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_status)

        tv_back = findViewById(R.id.tv_arrow)
        search = findViewById(R.id.tv_search)

        tv_back.setOnClickListener {
            startActivity(Intent(this,DashBoard::class.java))
            finish()
        }
    }
}