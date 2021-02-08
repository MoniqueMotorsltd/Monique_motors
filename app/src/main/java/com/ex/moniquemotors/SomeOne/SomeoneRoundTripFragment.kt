package com.ex.moniquemotors.SomeOne

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ex.moniquemotors.Book.RoundTrip
import com.ex.moniquemotors.R

class SomeoneRoundTripFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vvvv =  inflater.inflate(R.layout.fragment_someone_round_trip, container, false)

        val roundTrip22 = vvvv.findViewById<View>(R.id.roundTrip22) as Button

        roundTrip22.setOnClickListener {
            val fragment = SomeOneFragment()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentView,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            onDetach()
        }

        return  vvvv
    }

}