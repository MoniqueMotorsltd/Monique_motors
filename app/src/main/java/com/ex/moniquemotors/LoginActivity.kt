package com.ex.moniquemotors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val login_btn = findViewById(R.id.login_btn) as Button

        login_btn.setOnClickListener{
            startActivity(Intent(this,DashBoard::class.java))
            finish()
        }
    }
}