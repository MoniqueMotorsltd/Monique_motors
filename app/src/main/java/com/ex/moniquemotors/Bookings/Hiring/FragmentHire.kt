package com.ex.moniquemotors.Bookings.Hiring

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import com.ex.moniquemotors.Book.RoundTrip
import com.ex.moniquemotors.R
import kotlinx.android.synthetic.main.fragment_hire.*
import kotlinx.android.synthetic.main.fragment_one_way_trip.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


class FragmentHire : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val iv = inflater.inflate(R.layout.fragment_hire, container, false)

        val btn1 = iv.findViewById<View>(R.id.btn_cargo) as Button
        val hireDate = iv.findViewById<View>(R.id.hire_date) as Button
        val hireTime = iv.findViewById<View>(R.id.hire_time) as Button
        val radioGroup = iv.findViewById<View>(R.id.radiogroup_hire) as RadioGroup
        val radio1 = iv.findViewById<View>(R.id.radio_btn_onewaytrip) as RadioButton
        val radio2 = iv.findViewById<View>(R.id.radio_btn_roundtrip) as RadioButton
        val spinner = iv.findViewById<View>(R.id.spinner) as Spinner

        val timeFormat = SimpleDateFormat("hh:mm a",Locale.UK)
        val dateFormat = SimpleDateFormat("dd MMM,yyyy", Locale.UK)


        val now = Calendar.getInstance()
        hireDate.text = dateFormat.format(now.time)


        var number = arrayOf("Number Of Persons",1,2,3,4,5,6,7,8,9,10)
        spinner.adapter = ArrayAdapter<Any>(
            iv.context,
            android.R.layout.simple_list_item_1,
            number
        )


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                "Number Of Persons" == spinner.toString()
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

          btn1.setOnClickListener {
              val fragment = FragmentHireTwo()
              val fragmentManager = activity!!.supportFragmentManager
              val fragmentTransaction = fragmentManager.beginTransaction()
              fragmentTransaction.replace(R.id.view,fragment)
              fragmentTransaction.addToBackStack(null)
              fragmentTransaction.commit()

          }


        hireDate.setOnClickListener {
            val date6 = DatePickerDialog(
                iv.context,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    now.set(Calendar.YEAR,year)
                    now.set(Calendar.MONTH,month)
                    now.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                    hireDate.text = dateFormat.format(now.time)
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
            date6.show()
        }

        hireTime.setOnClickListener {
            val now7 = Calendar.getInstance()
            try{
                if (hireTime.text != "Time"){
                    val date = timeFormat.parse(time.text.toString())
                    now7.time = date
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
            val date7 = TimePickerDialog(
                iv.context,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                    val selectedTime = Calendar.getInstance()
                    selectedTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
                    selectedTime.set(Calendar.MINUTE,minute)
                    hireTime.text  = timeFormat.format(selectedTime.time)
                },
                now7.get(Calendar.HOUR_OF_DAY),
                now7.get(Calendar.MINUTE),
                false
            )
            date7.show()
        }

        return iv
    }


    }
