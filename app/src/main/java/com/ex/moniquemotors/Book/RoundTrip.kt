package com.ex.moniquemotors.Book

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.core.view.get
import com.ex.moniquemotors.Constant.Constant.routes
import com.ex.moniquemotors.R
import kotlinx.android.synthetic.main.fragment_one_way_trip.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*


class RoundTrip : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val vv = inflater.inflate(R.layout.fragment_round_trip, container, false)


        val btn11 = vv.findViewById<View>(R.id.Btn11) as Button
        val btn22 = vv.findViewById<View>(R.id.Btn22) as Button
        val date2 = vv.findViewById<View>(R.id.date2) as Button
        val time2 = vv.findViewById<View>(R.id.time2) as Button
        val rd_date = vv.findViewById<View>(R.id.rd_date) as Button
        val rd_time = vv.findViewById<View>(R.id.rd_time) as Button
        val btn_location = vv.findViewById<View>(R.id.btn_location) as Spinner
        val btn_destination =  vv.findViewById<View>(R.id.btn_destination) as Spinner
        var persons = vv.findViewById<View>(R.id.persons) as Spinner


        val dateFormat = SimpleDateFormat("dd MMM,yyyy", Locale.UK)
        val timeFormat = SimpleDateFormat("hh:mm a",Locale.UK)

        val now = Calendar.getInstance()
        date2.text = dateFormat.format(now.time)
        rd_date.text = dateFormat.format(now.time)



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
             btn_location.adapter = ArrayAdapter(vv.context,android.R.layout.simple_list_item_1,routes)
        btn_location.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
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
        btn_destination.adapter = ArrayAdapter(vv.context,android.R.layout.simple_list_item_1,routes)
        btn_destination.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val chosenItem = parent!!.getItemAtPosition(position)
            }

        }
        val number = arrayOf("Number Of Persons",1,2,3,4,5,6,7,8,9,10)
        persons.adapter = ArrayAdapter<Any>(vv.context,android.R.layout.simple_list_item_1, number)
        persons.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                "Number Of Persons" == persons.toString()
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

        btn11.setOnClickListener {
            val fragment = OneWayTrip()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentView,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }


        date2.setOnClickListener {
            val data = DatePickerDialog(
                vv.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    now.set(Calendar.YEAR,year)
                    now.set(Calendar.MONTH,month)
                    now.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                    date2.text = dateFormat.format(now.time)
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
            data.show()
        }

        time2.setOnClickListener {
            val now2 = Calendar.getInstance()
            try {
                if (time2.text != "Time"){
                    val date = timeFormat.parse(time2.text.toString())
                    now2.time = date
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
           val timer = TimePickerDialog(
                vv.context,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
                    selectedTime.set(Calendar.MINUTE,minute)
                    time2.text  = timeFormat.format(selectedTime.time) },
                now2.get(Calendar.HOUR_OF_DAY),
                now2.get(Calendar.MINUTE),
                false
            )
            timer.show()

        }

        rd_date.setOnClickListener {
            val date2 = DatePickerDialog(
                vv.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    now.set(Calendar.YEAR,year)
                    now.set(Calendar.MONTH,month)
                    now.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                    rd_date.text = dateFormat.format(now.time)
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
            date2.show()
        }

        rd_time.setOnClickListener {
            val now5 = Calendar.getInstance()
            try{
                if (rd_time.text != "Time"){
                    val date2 = timeFormat.parse(rd_time.text.toString())
                    now5.time = date2
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
            val date3 = TimePickerDialog(
                vv.context,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
                    selectedTime.set(Calendar.MINUTE,minute)
                    rd_time.text  = timeFormat.format(selectedTime.time)
                },
                now5.get(Calendar.HOUR_OF_DAY),
                now5.get(Calendar.MINUTE),
                false
            )
            date3.show()
        }

        return vv
    }
    }
