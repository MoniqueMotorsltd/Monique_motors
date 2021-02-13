package com.ex.moniquemotors.Book

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.SharedElementCallback
import androidx.core.view.get
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
        var numberOfPersons = v.findViewById<View>(R.id.numberOfPersons1) as Spinner


        var format = SimpleDateFormat("dd MMM,YYYY",Locale.UK)
        var timeFormat = SimpleDateFormat("hh:mm a",Locale.UK)



        val options = arrayOf(1,2,3,4,5,6,7,8,9,10)
        numberOfPersons.adapter = ArrayAdapter<Int>(
            v.context,
            android.R.layout.simple_list_item_1,
            options
        )
        numberOfPersons.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                "Number Of Persons" == numberOfPersons.toString()
            }

            override fun onItemSelected(parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                numberOfPersons.get(position)
            }

        }

        btn2.setOnClickListener {
            val fragment = RoundTrip()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentView,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }


       date.setOnClickListener {
            val now = Calendar.getInstance()
            val date = DatePickerDialog(
                v.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(Calendar.YEAR,year)
                    selectedDate.set(Calendar.MONTH,month)
                    selectedDate.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                    val day = format.format(selectedDate.time)
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
            date.show()
       }

        time.setOnClickListener {
            val now = Calendar.getInstance()
         try {
             if (time.text != "Time"){
                 val date = timeFormat.parse(time.text.toString())
                 now.time = date
             }
         } catch(e:Exception){
             e.printStackTrace()
         }
            val time = TimePickerDialog(
                v.context,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
                    selectedTime.set(Calendar.MINUTE,minute)
                    time.text  = timeFormat.format(selectedTime.time)
                },
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                false
            )
            time.show()


        }


        return v
    }


}