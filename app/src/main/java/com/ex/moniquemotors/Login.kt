package com.ex.moniquemotors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    lateinit var regBtn:Button
    lateinit var logBtn:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        regBtn = findViewById(R.id.reg2)
        logBtn = findViewById(R.id.btn_login)



        btn_login.setOnClickListener {
            startActivity(Intent(this,DashBoard::class.java))
            finish()
        }

        reg2.setOnClickListener {
            startActivity(Intent(this,SignUp::class.java))
            finish()
        }
    }
}