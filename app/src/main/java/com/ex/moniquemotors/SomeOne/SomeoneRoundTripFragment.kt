package com.ex.moniquemotors.SomeOne

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
import com.ex.moniquemotors.Book.RoundTrip
import com.ex.moniquemotors.R
import kotlinx.android.synthetic.main.fragment_someone_round_trip.view.*
import java.util.*

class SomeoneRoundTripFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vvvv =  inflater.inflate(R.layout.fragment_someone_round_trip, container, false)

        val roundTrip22 = vvvv.findViewById<View>(R.id.roundTrip22) as Button
        val someOneDate2 = vvvv.findViewById<View>(R.id.some_one_date2) as  Button
        val someOneTime2 = vvvv.findViewById<View>(R.id.some_one_time2) as Button
        val someOneDate3 = vvvv.findViewById<View>(R.id.tv_some_one_date2) as Button
        val someOneTime3 = vvvv.findViewById<View>(R.id.tv_some_one_time2) as Button
        val spinner = vvvv.findViewById<View>(R.id.personSpinner) as Spinner


        val people = arrayOf(1,2,3,4,5,6,7,8,9,10)
        spinner.adapter = ArrayAdapter<Int>(vvvv.context,android.R.layout.simple_list_item_1,people)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                spinner.toString() == "Number Of Persons"
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
               spinner.get(position)
            }

        }

        roundTrip22.setOnClickListener {
            val fragment = SomeOneFragment()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentView,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            onDestroy()
        }

        someOneDate2.setOnClickListener {
            val now6 = Calendar.getInstance()
            val date6 = DatePickerDialog(
                vvvv.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->  },
                now6.get(Calendar.YEAR),
                now6.get(Calendar.MONTH),
                now6.get(Calendar.DAY_OF_MONTH)
            )
            date6.show()
        }
        someOneTime2.setOnClickListener {
            val now7 = Calendar.getInstance()
            val date7 = TimePickerDialog(
                vvvv.context,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->  },
                now7.get(Calendar.HOUR_OF_DAY),
                now7.get(Calendar.MINUTE),
                false
            )
            date7.show()
        }

        someOneDate3.setOnClickListener {
            val exact = Calendar.getInstance()
            val moment = DatePickerDialog(
                vvvv.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->  },
                exact.get(Calendar.YEAR),
                exact.get(Calendar.MONTH),
                exact.get(Calendar.DAY_OF_MONTH)
            )
            moment.show()
        }
        someOneTime3.setOnClickListener {
            val next = Calendar.getInstance()
            val nxt = TimePickerDialog(
                vvvv.context,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->  },
                next.get(Calendar.HOUR_OF_DAY),
                next.get(Calendar.MINUTE),
                false
            )
            nxt.show()
        }
        return  vvvv
    }

}