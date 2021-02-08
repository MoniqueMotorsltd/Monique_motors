package com.ex.moniquemotors.Bookings.Hiring

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ex.moniquemotors.R


class FragmentHireTwo : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vi = inflater.inflate(R.layout.fragment_hire_two, container, false)

        val btn_passenger = vi.findViewById<View>(R.id.btn_passenger) as Button

        btn_passenger.setOnClickListener {
            val fragment = FragmentHire()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.view,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            onDetach()
        }

        return vi
    }

    }
