package com.alpha.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import com.alpha.myapplication.R
import com.alpha.myapplication.api.NearEarthObjects

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val fragmentInflater = inflater.inflate(R.layout.fragment_home, container, false) as ScrollView

        val earthContainer = fragmentInflater.getChildAt(0) as LinearLayout

        NearEarthObjects(requireActivity().applicationContext).populateObjectsToView(earthContainer)

        return fragmentInflater
    }

}