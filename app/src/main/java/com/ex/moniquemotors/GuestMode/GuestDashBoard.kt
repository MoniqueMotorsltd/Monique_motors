package com.ex.moniquemotors.GuestMode

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.ex.moniquemotors.R
import com.ex.moniquemotors.Register.LoginActivity
import com.ex.moniquemotors.Register.ReviewActivity
import com.ex.moniquemotors.Register.SignUp

class GuestDashBoard : AppCompatActivity() {


    lateinit var back: ImageView
    lateinit var bk1: Button
    lateinit var bk2: Button
    lateinit var bk3: Button
    lateinit var bk4: Button
    lateinit var bk5: Button
    lateinit var bk6: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_dash_board)

        bk1 = findViewById(R.id.bk1)
        bk2 = findViewById(R.id.bk2)
        bk3 = findViewById(R.id.bk3)
        bk4 = findViewById(R.id.bk4)
        bk5 = findViewById(R.id.bk5)
        bk6 = findViewById(R.id.bk6)
        back = findViewById(R.id.arrow)


        bk1.setOnClickListener {
            startActivity(Intent(this,GuestBookASit::class.java))
        }
        bk2.setOnClickListener {

        }
        bk3.setOnClickListener {
            showDialogue()
        }

        bk4.setOnClickListener {
            showDialogue()
        }

        bk5.setOnClickListener {
            showDialogue()
        }

        bk6.setOnClickListener {
            showDialogue()
        }


        back.setOnClickListener {
            startActivity(Intent(this,ReviewActivity::class.java))
            finish()
        }


    }

    private fun showDialogue() {
        val disallow = AlertDialog.Builder(this)
        disallow.setIcon(R.drawable.moniquelogo)
        disallow.setTitle("Attention")
        disallow.setMessage("Do you want to Sign-up ?. ")
        disallow.setNegativeButton("Cancel",{ dialogInterface: DialogInterface, i: Int ->
        })
        disallow.setPositiveButton("Sign-Up",{ dialogInterface: DialogInterface, i: Int ->
            startActivity(Intent(this,SignUp::class.java))
            finish()
        })
        disallow.show()
    }
}