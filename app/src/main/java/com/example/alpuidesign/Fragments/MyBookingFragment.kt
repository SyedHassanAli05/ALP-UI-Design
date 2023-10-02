package com.example.alpuidesign.Fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.alpuidesign.R
import com.example.alpuidesign.databinding.ActivityHomeFragmentBinding
import com.example.alpuidesign.databinding.ActivityMyBookingFragmentBinding

class MyBookingFragment : Fragment() {
    var binding:ActivityMyBookingFragmentBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<ActivityMyBookingFragmentBinding>(inflater,R.layout.activity_my_booking_fragment, container, false)
        return binding?.getRoot()
    }
}