package com.ex.moniquemotors

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
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