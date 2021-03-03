package com.ex.moniquemotors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class BusTypeActivity : AppCompatActivity() {

    lateinit var back: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_type)

        back = findViewById(R.id.imageBack)


        back.setOnClickListener {
            finish()
        }
    }
}