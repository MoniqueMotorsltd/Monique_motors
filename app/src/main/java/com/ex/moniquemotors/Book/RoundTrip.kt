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
import com.ex.moniquemotors.R
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
        var persons = vv.findViewById<View>(R.id.persons) as Spinner

        val options1 = arrayOf(1,2,3,4,5,6,7,8,9,10)

        persons.adapter = ArrayAdapter<Int>(vv.context,android.R.layout.simple_list_item_1,options1)


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
                persons.get(position)
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
            val now = Calendar.getInstance()
            val data = DatePickerDialog(
                vv.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->  },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
            data.show()
        }

        time2.setOnClickListener {
            val now2 = Calendar.getInstance()
           val timer = TimePickerDialog(
                vv.context,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->  },
                now2.get(Calendar.HOUR_OF_DAY),
                now2.get(Calendar.MINUTE),
                false
            )
            timer.show()

        }

        rd_date.setOnClickListener {
            val now4 = Calendar.getInstance()
            val date2 = DatePickerDialog(
                vv.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->  },
                now4.get(Calendar.YEAR),
                now4.get(Calendar.MONTH),
                now4.get(Calendar.DAY_OF_MONTH)
            )
            date2.show()
        }
        rd_time.setOnClickListener {
            val now5 = Calendar.getInstance()
            val date3 = TimePickerDialog(
                vv.context,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->  },
                now5.get(Calendar.HOUR_OF_DAY),
                now5.get(Calendar.MINUTE),
                false
            )
            date3.show()
        }

        return vv
    }


    }
