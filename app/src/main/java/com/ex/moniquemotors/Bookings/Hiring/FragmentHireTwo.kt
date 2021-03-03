package com.ex.moniquemotors.Bookings.Hiring

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
import com.ex.moniquemotors.R
import kotlinx.android.synthetic.main.fragment_one_way_trip.*
import java.text.SimpleDateFormat
import java.util.*


class FragmentHireTwo : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vi = inflater.inflate(R.layout.fragment_hire_two, container, false)

        val btn_passenger = vi.findViewById<View>(R.id.btn_passenger) as Button
        val hire_date_two = vi.findViewById<View>(R.id.hire_date_two) as Button
        val hire_time_two = vi.findViewById<View>(R.id.hire_time_two) as Button
        val spinner2 = vi.findViewById<View>(R.id.spinner2) as Spinner


        val timeFormat = SimpleDateFormat("hh:mm a",Locale.UK)
        val dateFormat = SimpleDateFormat("dd MMM,yyyy", Locale.UK)


        val now = Calendar.getInstance()
        hire_date_two.text = dateFormat.format(now.time)



        val options2 = arrayOf("Number Of Persons",1,2,3,4,5,6,7,8,9,10)

        spinner2.adapter = ArrayAdapter<Any>(vi.context,android.R.layout.simple_list_item_1,options2)

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                "Number Of Persons" == spinner2.toString()
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

        btn_passenger.setOnClickListener {
            val fragment = FragmentHire()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.view,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        hire_date_two.setOnClickListener {
            val date = DatePickerDialog(
                vi.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    now.set(Calendar.YEAR,year)
                    now.set(Calendar.MONTH,month)
                    now.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                    hire_date_two.text = dateFormat.format(now.time)
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
                 date.show()
        }

        hire_time_two.setOnClickListener {
            val  moment = Calendar.getInstance()
            try{
                if(hire_time_two.text != "Time"){
                    val date = timeFormat.parse(time.text.toString())
                    moment.time = date
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
            val timer = TimePickerDialog(
                vi.context,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
                    selectedTime.set(Calendar.MINUTE,minute)
                    hire_time_two.text  = timeFormat.format(selectedTime.time)
                },
                moment.get(Calendar.HOUR_OF_DAY),
                moment.get(Calendar.MINUTE),
                false
            )
            timer.show()
        }



        return vi
    }

    }
