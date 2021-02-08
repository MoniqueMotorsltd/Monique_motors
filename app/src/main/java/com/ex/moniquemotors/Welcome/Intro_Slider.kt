package com.ex.moniquemotors.Welcome

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.ex.moniquemotors.R
import com.ex.moniquemotors.Register.ReviewActivity
import kotlinx.android.synthetic.main.activity_intro__slider.*

class Intro_Slider : AppCompatActivity() {

    val fragment1 = Slider_Fragment()
    val fragment2 = Slider_Fragment()
    val fragment3 = Slider_Fragment()
    lateinit var adapter: myPagerAdapter
    lateinit var activity: Activity



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro__slider)

        activity = this
        fragment1.title("${R.drawable.covid19}")
        fragment2.title("${R.drawable.covid19image}")
        fragment3.title("${R.drawable.covid19image2}")


        adapter = myPagerAdapter(
            supportFragmentManager
        )
        adapter.list.add(fragment1)
        adapter.list.add(fragment2)
        adapter.list.add(fragment3)


        view_pager.adapter = adapter
        btn_next.setOnClickListener {
            view_pager.currentItem++
        }
        btn_skip.setOnClickListener {
            goToDashBoard()
        }

          view_pager.addOnPageChangeListener(object  : ViewPager.OnPageChangeListener{
              override fun onPageScrollStateChanged(state: Int) {
              }

              override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

              }

              override fun onPageSelected(position: Int) {
                  if (position == adapter.list.size -1 ){
                      btn_next.text = "DONE"
                      btn_next.setOnClickListener {
                          startActivity(Intent(activity,
                              ReviewActivity::class.java))
                          finish()
                      }
                  }else{
                      btn_next.text = "NEXT"
                      btn_next.setOnClickListener {
                          view_pager.currentItem++
                      }
                  }
                  when(view_pager.currentItem){
                      0 -> {
                           indicator1.setTextColor(Color.BLACK)
                          indicator2.setTextColor(Color.GRAY)
                          indicator3.setTextColor(Color.GRAY)
                      }
                      1 -> {
                          indicator1.setTextColor(Color.GRAY)
                          indicator2.setTextColor(Color.BLACK)
                          indicator3.setTextColor(Color.GRAY)

                      }
                      2 ->{
                          indicator1.setTextColor(Color.GRAY)
                          indicator2.setTextColor(Color.GRAY)
                          indicator3.setTextColor(Color.BLACK)

                      }
                  }

              }

          })


    }

    fun goToDashBoard(){
        startActivity(Intent(this, ReviewActivity::class.java))
        finish()
    }
    class myPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){

        val list : MutableList<Fragment> = ArrayList()

        override fun getItem(position: Int): Fragment {
           return list[position]
        }

        override fun getCount(): Int {
            return list.size
        }

    }
}