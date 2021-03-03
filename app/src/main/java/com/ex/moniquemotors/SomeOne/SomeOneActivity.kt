package com.ex.moniquemotors.SomeOne

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.ex.moniquemotors.Book.OneWayTrip
import com.ex.moniquemotors.Drawer.DashBoard
import com.ex.moniquemotors.R
import kotlinx.android.synthetic.main.activity_some_one.*

class SomeOneActivity : AppCompatActivity() {


    override fun onBackPressed() {
        finish()
    }

    lateinit var backButton:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_some_one)

        backButton = findViewById(R.id.behind)

        backButton.setOnClickListener {
            startActivity(Intent(this,DashBoard::class.java))
            finish()
        }



        val fragment = SomeOneFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout,fragment)
        transaction.commit()
    }
}