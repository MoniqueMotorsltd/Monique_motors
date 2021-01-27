package com.ex.moniquemotors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {

    lateinit var btn1:Button
    lateinit var  btn2: Button
    lateinit var edit1: TextInputEditText
    lateinit var edit2: TextInputEditText
    lateinit var  edit3: TextInputEditText
    lateinit var edit4: TextInputEditText
    lateinit var edit5: TextInputEditText
    lateinit var edit6: TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


//Assigning variables to views......


        btn1 = findViewById(R.id.btn_register)
        btn2 = findViewById(R.id.btn__account)
        edit1 = findViewById(R.id.name)
        edit2 = findViewById(R.id.number)
        edit3 = findViewById(R.id.age)
        edit4 = findViewById(R.id.password)
        edit5 = findViewById(R.id.email)
        edit6 = findViewById(R.id.nextOfKin)






        btn__account.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
            finish()
        }
    }


}