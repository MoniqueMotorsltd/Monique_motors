package com.ex.moniquemotors

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class DashBoard : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar:Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView :NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        //declaring animation below

        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);

        //declaring buttons below

        val cardview1 = findViewById(R.id.cardview1) as CardView
        val cardview2 = findViewById(R.id.cardview2) as CardView
        val cardview3 = findViewById(R.id.cardview3) as CardView
        val cardview4 = findViewById(R.id.cardview4) as CardView
        val cardview5 = findViewById(R.id.cardview5) as CardView
        val layout = findViewById(R.id.layout) as LinearLayout


        //setting the animation below

        cardview1.startAnimation(ttb)
        cardview2.startAnimation(ttb)
        cardview3.startAnimation(ttb)
        cardview4.startAnimation(ttb)
        cardview5.startAnimation(ttb)
        layout.startAnimation(ttb)

        
         toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerlayout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this,drawerLayout,toolbar,0,0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener (this)

        val book1 = findViewById(R.id.book1) as Button

        book1.setOnClickListener{
            startActivity(Intent(this,BookingActivity::class.java))
            finish()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
      when(item.itemId){
          R.id.nav_profile -> {
              startActivity(Intent(this,Profile::class.java))
          }
          R.id.nav_rate -> {
              Toast.makeText(this,"Rating was clicked",Toast.LENGTH_SHORT).show()
          }
          R.id.nav_about -> {
              val dialogue = AlertDialog.Builder(this)
              dialogue.setIcon(R.drawable.moniquelogo)
              dialogue.setTitle("About Us")
              dialogue.setMessage("The message should be here.........")
              dialogue.setPositiveButton("Ok",{ dialogInterface: DialogInterface, i: Int ->
              })
              dialogue.show()
          }
          R.id.nav_whatsapp ->{
              Toast.makeText(this,"WhatsApp was clicked",Toast.LENGTH_SHORT).show()
          }
          R.id.nav_twitter ->{
              Toast.makeText(this,"Twitter was clicked",Toast.LENGTH_SHORT).show()
          }
          R.id.nav_instagram ->{
              Toast.makeText(this,"Instagram was clicked",Toast.LENGTH_SHORT).show()
          }
          R.id.send->{
              Toast.makeText(this,"Send was clicked",Toast.LENGTH_SHORT).show()
          }
      }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}