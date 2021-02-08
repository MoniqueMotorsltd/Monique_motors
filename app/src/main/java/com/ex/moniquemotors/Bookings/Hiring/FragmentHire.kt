package com.ex.moniquemotors.Bookings.Hiring

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ex.moniquemotors.Book.RoundTrip
import com.ex.moniquemotors.R
import kotlinx.android.synthetic.main.fragment_hire.*


class FragmentHire : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val iv = inflater.inflate(R.layout.fragment_hire, container, false)

        val btn1 = iv.findViewById<View>(R.id.btn_cargo) as Button

          btn_cargo.setOnClickListener {
              val fragment = FragmentHireTwo()
              val fragmentManager = activity!!.supportFragmentManager
              val fragmentTransaction = fragmentManager.beginTransaction()
              fragmentTransaction.replace(R.id.view,fragment)
              fragmentTransaction.addToBackStack(null)
              fragmentTransaction.commit()

          }

        return iv
    }


    }
