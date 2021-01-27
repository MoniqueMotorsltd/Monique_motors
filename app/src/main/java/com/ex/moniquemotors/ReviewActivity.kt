package com.ex.moniquemotors

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_review.*

class ReviewActivity : AppCompatActivity() {


    override fun onBackPressed() {
        val alert = AlertDialog.Builder(this)
        alert.setIcon(R.drawable.moniquelogo)
        alert.setTitle("Attention")
        alert.setMessage("Do you want to exit this app?")
        alert.setPositiveButton("Yes",{ dialogInterface: DialogInterface, i: Int ->
            finish()
        })
        alert.setNegativeButton("No",{ dialogInterface: DialogInterface, i: Int -> })
        alert.show()

    }

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)



        btn1 = findViewById(R.id.button)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)

        button.setOnClickListener {
            startActivity(Intent(this,SignUp::class.java))
        }

        button2.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
        }

        button3.setOnClickListener {
            startActivity(Intent(this,DashBoard::class.java))
        }


    }
}