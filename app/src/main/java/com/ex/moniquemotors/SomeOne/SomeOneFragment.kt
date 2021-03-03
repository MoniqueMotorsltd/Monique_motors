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
import kotlinx.android.synthetic.main.fragment_some_one.*
import java.lang.Exception
import java.text.SimpleDateFormat
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
        val location = vvv.findViewById<View>(R.id.location) as Spinner
        val destination = vvv.findViewById<View>(R.id.destination) as Spinner
        val spinnerPersons = vvv.findViewById<View>(R.id.spinnerPerson) as Spinner

        val timeFormat = SimpleDateFormat("hh:mm a",Locale.UK)
        val dateFormat = SimpleDateFormat("dd MMM,yyyy", Locale.UK)

        val now = Calendar.getInstance()
        someOneDate.text = dateFormat.format(now.time)




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
        location.adapter  = ArrayAdapter(vvv.context,android.R.layout.simple_list_item_1,routes)
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
        destination.adapter = ArrayAdapter(vvv.context,android.R.layout.simple_list_item_1,routes)
        destination.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val chioce = parent!!.getItemAtPosition(position)
            }

        }


        val number = arrayOf("Number Of Persons",1,2,3,4,5,6,7,8,9,10)
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
                val selectedItem = parent!!.getItemAtPosition(position)
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
            val date6 = DatePickerDialog(
                vvv.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    now.set(Calendar.YEAR,year)
                    now.set(Calendar.MONTH,month)
                    now.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                    someOneDate.text = dateFormat.format(now.time)
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
            date6.show()
        }

        someOneTime.setOnClickListener {
            val value = Calendar.getInstance()
            try{
                if(someOneTime.text != "Time"){
                val date = timeFormat.parse(time.text.toString())
                value.time = date
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
            val date7 = TimePickerDialog(
                vvv.context,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
                    selectedTime.set(Calendar.MINUTE,minute)
                    someOneTime.text  = timeFormat.format(selectedTime.time)
                },
                value.get(Calendar.HOUR_OF_DAY),
                value.get(Calendar.MINUTE),
                false
            )
            date7.show()
        }

        return vvv
    }

}