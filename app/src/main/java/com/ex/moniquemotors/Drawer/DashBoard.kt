package com.ex.moniquemotors.Drawer

import android.content.ActivityNotFoundException
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.ex.moniquemotors.Book.BookingActivity
import com.ex.moniquemotors.BookingSatus.BookingStatus
import com.ex.moniquemotors.Bookings.Hiring.Hire
import com.ex.moniquemotors.Constant.Constant.APP_LINK
import com.ex.moniquemotors.Constant.Constant.CUSTOMER_SERVICE
import com.ex.moniquemotors.History.History
import com.ex.moniquemotors.Logistics.LogisticsActivity
import com.ex.moniquemotors.R
import com.ex.moniquemotors.SomeOne.SomeOneActivity
import com.google.android.material.navigation.NavigationView

class DashBoard : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar:Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView :NavigationView
    lateinit var uriString: String

    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var button5: Button
    lateinit var button6: Button

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        recreate()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)


        button1 = findViewById(R.id.book1)
        button2 = findViewById(R.id.book2)
        button3 = findViewById(R.id.book3)
        button4 = findViewById(R.id.book4)
        button5 = findViewById(R.id.book5)
        button6 = findViewById(R.id.book6)


        button1.setOnClickListener {
            startActivity(
                Intent(this, BookingActivity::class.java)
            )
        }

        button2.setOnClickListener {
            startActivity(Intent(this,Hire::class.java))
        }

        button3.setOnClickListener {
            startActivity(Intent(this,LogisticsActivity::class.java))
        }

        button4.setOnClickListener {
            startActivity(Intent(this,SomeOneActivity::class.java))
        }

        button5.setOnClickListener {
            startActivity(Intent(this,BookingStatus::class.java))
        }

        button6.setOnClickListener {
          val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("Email")
            val stringArray = arrayOf("moniquemotorslimited@gmail.com","support@moniquemotorsltd.com.ng")
            intent.putExtra(Intent.EXTRA_EMAIL,stringArray)
            intent.putExtra(Intent.EXTRA_SUBJECT,"This is the field subject")
            intent.type = "message/rfc822"
            val a = Intent.createChooser(intent,"Launch Email:")
            startActivity(a)
        }




        
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
              startActivity(Intent(this, Profile::class.java))
          }
          R.id.nav_rate -> {
              val intent = Intent(Intent.ACTION_VIEW, Uri.parse(APP_LINK))
              startActivity(intent)
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
          R.id.nav_customer ->{
              val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",CUSTOMER_SERVICE,null))
              startActivity(intent)
          }
          R.id.nav_history -> {
              startActivity(Intent(this, History::class.java))
          }
          R.id.facebook ->{
              if (isFacebookInstalled){
                  share("com.facebook.katana")
              }else{
                  share("com.facebook.lite")
              }
          }
          R.id.twitter ->{
              share("com.twitter.android")
          }
          R.id.instagram ->{
              share("com.instagram.android")
          }
          R.id.whatsapp ->{
              share("com.whatsapp")
          }

          R.id.send ->{
              val intent = Intent(Intent.ACTION_SEND)
              uriString = "Book a ride with app"+"https://play.google.com/store/apps/details?id=com.pca.motors&hl=en"
              intent.type = "type/plain"
              intent.putExtra(Intent.EXTRA_SUBJECT,uriString)
              startActivity(Intent.createChooser(intent,"Share to:  "))
          }
      }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun share(packageName:String){
        val message =
            "Hi There! It's time to update your travel experience. I've enjoyed the convenience of Monique Motors using their app for my bus ticket and vehicle hire bookings. You can experience same by downloading their free app with this link below$APP_LINK"
        Intent().let {
            it.action = Intent.ACTION_SEND
            it.putExtra(Intent.EXTRA_TEXT, message)
            it.type = "text/plain"
            it.`package` = packageName

            val shareIntent = Intent.createChooser(it, null)
            try {
                startActivity(shareIntent)
            }catch (e: ActivityNotFoundException){
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }
}

    private val isFacebookInstalled: Boolean
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        get() {
            val pm = packageManager
            val installed: Boolean
            installed = try {
                pm.getPackageInfo("com.facebook.katana",
                    PackageManager.GET_ACTIVITIES)
                true
            } catch (e: PackageManager.NameNotFoundException) {
                false
            }
            return installed
        }

}