package com.ex.moniquemotors.SomeOne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ex.moniquemotors.Book.OneWayTrip
import com.ex.moniquemotors.R
import kotlinx.android.synthetic.main.activity_some_one.*

class SomeOneActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_some_one)


        val fragment = SomeOneFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout,fragment)
        transaction.commit()
    }
}