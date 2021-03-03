 package com.ex.moniquemotors.Book

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.SharedElementCallback
import androidx.core.view.get
import com.ex.moniquemotors.BusTypeActivity
import com.ex.moniquemotors.Constant.Constant.routes
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
        val next = v.findViewById<View>(R.id.tv_nxt) as Button
        val button_location = v.findViewById<View>(R.id.button_location) as Spinner
        val button_destination = v.findViewById<View>(R.id.button_destination) as Spinner
        var numberOfPersons = v.findViewById<View>(R.id.numberOfPersons1) as Spinner



        val dateFormat = SimpleDateFormat("dd MMM,yyyy", Locale.UK)
        val timeFormat = SimpleDateFormat("hh:mm a",Locale.UK)


        val now = Calendar.getInstance()
        date.text = dateFormat.format(now.time)


        val routes = arrayOf("Aba",
            "Lagos",
            "Umuahia",
            "Mbaise",
            "Owerri",
            "Asaba",
            "Onitsha",
            "Uli",
            "Ihiala",
            "Benin",
            "Enugu",
            "Abakaliki",
            "Portharcourt",
            "Abuja")
        button_location.adapter = ArrayAdapter(v.context,android.R.layout.simple_list_item_1,routes)
        button_location.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent!!.getItemAtPosition(position)
            }
        }

        button_destination.adapter = ArrayAdapter(v.context,android.R.layout.simple_list_item_1,routes())
        button_destination.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent!!.getItemAtPosition(position)
            }

        }
        val number = arrayOf("Number Of Persons",1,2,3,4,5,6,7,8,9,10)
        numberOfPersons.adapter = ArrayAdapter<Any>(
            v.context,
            android.R.layout.simple_list_item_1,
              number
        )
        numberOfPersons.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
               val selectedItem = parent!!.getItemAtPosition(position)

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
            val date = DatePickerDialog(
                v.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    now.set(Calendar.YEAR,year)
                    now.set(Calendar.MONTH,month)
                    now.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                   date.text = dateFormat.format(now.time)
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


        next.setOnClickListener{
            startActivity(Intent(v.context,BusTypeActivity::class.java))
        }


        return v
    }


}