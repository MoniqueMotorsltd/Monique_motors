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
import com.ex.moniquemotors.Constant.Constant.routes
import com.ex.moniquemotors.R
import kotlinx.android.synthetic.main.fragment_one_way_trip.*
import kotlinx.android.synthetic.main.fragment_someone_round_trip.view.*
import java.text.SimpleDateFormat
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
        val location = vvvv.findViewById<View>(R.id.tv_location) as Spinner
        val destination = vvvv.findViewById<View>(R.id.tv_destination) as Spinner
        val spinner = vvvv.findViewById<View>(R.id.personSpinner) as Spinner


        val timeFormat = SimpleDateFormat("hh:mm a",Locale.UK)
        val dateFormat = SimpleDateFormat("dd MMM,yyyy", Locale.UK)


        val now = Calendar.getInstance()
        someOneDate2.text = dateFormat.format(now.time)


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
        location.adapter  = ArrayAdapter(vvvv.context,android.R.layout.simple_list_item_1,routes)
        location.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item = parent!!.getItemAtPosition(position)
            }

        }
        val number = arrayOf("Number Of Persons",1,2,3,4,5,6,7,8,9,10)
        spinner.adapter = ArrayAdapter<Any>(vvvv.context,android.R.layout.simple_list_item_1, number)
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
               val selectedItem = parent!!.getItemAtPosition(position)
            }

        }

        roundTrip22.setOnClickListener {
            val fragment = SomeOneFragment()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayout,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        someOneDate2.setOnClickListener {
            val date6 = DatePickerDialog(
                vvvv.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    now.set(Calendar.YEAR,year)
                    now.set(Calendar.MONTH,month)
                    now.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                    someOneDate2.text = dateFormat.format(now.time)
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
            date6.show()
        }

        someOneTime2.setOnClickListener {
            val now7 = Calendar.getInstance()
            try {
                if(someOneTime2.text != "Time"){
                val date = timeFormat.parse(time.text.toString())
                now7.time = date
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
            val date7 = TimePickerDialog(
                vvvv.context,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
                    selectedTime.set(Calendar.MINUTE,minute)
                    someOneTime2.text  = timeFormat.format(selectedTime.time)
                },
                now7.get(Calendar.HOUR_OF_DAY),
                now7.get(Calendar.MINUTE),
                false
            )
            date7.show()
        }

        someOneDate3.setOnClickListener {
            val moment = DatePickerDialog(
                vvvv.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    now.set(Calendar.YEAR,year)
                    now.set(Calendar.MONTH,month)
                    now.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                    someOneDate3.text = dateFormat.format(now.time)
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
            moment.show()
        }


        someOneTime3.setOnClickListener {
            val next = Calendar.getInstance()
            try {
                if (someOneTime3.text != "Time"){
                    val date = timeFormat.parse(time.text.toString())
                    next.time = date
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
            val nxt = TimePickerDialog(
                vvvv.context,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
                    selectedTime.set(Calendar.MINUTE,minute)
                    time.text  = timeFormat.format(selectedTime.time)
                },
                next.get(Calendar.HOUR_OF_DAY),
                next.get(Calendar.MINUTE),
                false
            )
            nxt.show()
        }
        return  vvvv
    }

}