package com.ex.moniquemotors.Book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ex.moniquemotors.R


class RoundTrip : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val vv = inflater.inflate(R.layout.fragment_round_trip, container, false)


        val btn11 = vv.findViewById<View>(R.id.Btn11) as Button
        val btn22 = vv.findViewById<View>(R.id.Btn22) as Button

        btn11.setOnClickListener {
            val fragment = OneWayTrip()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentView,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return vv
    }


    }
