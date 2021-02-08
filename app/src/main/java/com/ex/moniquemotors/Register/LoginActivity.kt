package com.ex.moniquemotors.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ex.moniquemotors.Drawer.DashBoard
import com.ex.moniquemotors.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var loginButton: Button
    lateinit var noButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.btn_login)
        noButton = findViewById(R.id.reg2)



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
