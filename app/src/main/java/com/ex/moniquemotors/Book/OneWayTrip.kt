package com.ex.moniquemotors.Book

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import com.ex.moniquemotors.R
import kotlinx.android.synthetic.main.activity_booking.*
import java.text.SimpleDateFormat
import java.util.*


class OneWayTrip : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_one_way_trip, container, false)

        val btn = v.findViewById<View>(R.id.ButtonOne) as Button
        val btn2 = v.findViewById<View>(R.id.ButtonTwo) as Button
        val date = v.findViewById<View>(R.id.date) as Button
        val time = v.findViewById<View>(R.id.time) as Button

        var timeFormat = SimpleDateFormat("hh:mm a",Locale.UK)



        btn2.setOnClickListener {
            val fragment = RoundTrip()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentView,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }


      /* date.setOnClickListener {
            val now = Calendar.getInstance()
            val date = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->  },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
            date.show()

        }

        time.setOnClickListener {
            val now = Calendar.getInstance()
            val time = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->  },
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                false
            )
            time.show()


        }*/


        return v
    }


}