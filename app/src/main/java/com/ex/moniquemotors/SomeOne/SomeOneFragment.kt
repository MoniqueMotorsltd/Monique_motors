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
import kotlinx.android.synthetic.main.fragment_some_one.*
import java.util.*

class SomeOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val vvv = inflater.inflate(R.layout.fragment_some_one, container, false)

        val roundBtn = vvv.findViewById<View>(R.id.roundTrip) as Button
        val someOneDate = vvv.findViewById<View>(R.id.some_one_date) as Button
        val someOneTime = vvv.findViewById<View>(R.id.some_one_time) as Button
        val spinnerPersons = vvv.findViewById<View>(R.id.spinnerPerson) as Spinner


        val number = arrayOf(1,2,3,4,5,6,7,8,9,10)
        spinnerPersons.adapter = ArrayAdapter(vvv.context,android.R.layout.simple_list_item_1,number)
        spinnerPersons.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                 spinnerPersons.toString() == "Number Of Persons"
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                spinnerPersons.get(position)
            }

        }


        roundBtn.setOnClickListener {
            val fragment = SomeoneRoundTripFragment()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayout,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            onDetach()
        }

        someOneDate.setOnClickListener {
            val now6 = Calendar.getInstance()
            val date6 = DatePickerDialog(
                vvv.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->  },
                now6.get(Calendar.YEAR),
                now6.get(Calendar.MONTH),
                now6.get(Calendar.DAY_OF_MONTH)
            )
            date6.show()
        }

        someOneTime.setOnClickListener {
            val value = Calendar.getInstance()
            val date7 = TimePickerDialog(
                vvv.context,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->  },
                value.get(Calendar.HOUR_OF_DAY),
                value.get(Calendar.MINUTE),
                false
            )
            date7.show()
        }

        return vvv
    }

}