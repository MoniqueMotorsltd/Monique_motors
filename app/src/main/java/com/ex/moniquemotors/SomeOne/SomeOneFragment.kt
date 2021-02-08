package com.ex.moniquemotors.SomeOne

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ex.moniquemotors.Book.RoundTrip
import com.ex.moniquemotors.R
import kotlinx.android.synthetic.main.fragment_some_one.*

class SomeOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val vvv = inflater.inflate(R.layout.fragment_some_one, container, false)

        val roundBtn = vvv.findViewById<View>(R.id.roundTrip) as Button


        roundBtn.setOnClickListener {
            val fragment = SomeoneRoundTripFragment()
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayout,fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            onDetach()
        }

        return vvv
    }

}