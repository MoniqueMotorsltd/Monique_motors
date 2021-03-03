package com.ex.moniquemotors.Welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ex.moniquemotors.R
import kotlinx.android.synthetic.main.fragment_slider_.*

class Slider_Fragment : Fragment() {



   // var pageTitle: String = ""


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_slider_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      //  fragment_title.text = pageTitle
    }



    fun title(title: String){
     //   pageTitle = title
    }

}