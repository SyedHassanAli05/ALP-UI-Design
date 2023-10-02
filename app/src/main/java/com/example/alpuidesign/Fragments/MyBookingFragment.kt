package com.example.alpuidesign.Fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alpuidesign.Activities.BookingDetailActivity
import com.example.alpuidesign.AdapterClasses.AdapterBookingLists
import com.example.alpuidesign.ModelClasses.ModelBookingLists
import com.example.alpuidesign.R
import com.example.alpuidesign.databinding.ActivityHomeFragmentBinding
import com.example.alpuidesign.databinding.ActivityMyBookingFragmentBinding

class MyBookingFragment : Fragment() {
    var binding:ActivityMyBookingFragmentBinding?=null
    lateinit var rvBookingList:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<ActivityMyBookingFragmentBinding>(inflater,R.layout.activity_my_booking_fragment, container, false)
        return binding?.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTopBar()
        setRecyclerView()
    }



    private fun setRecyclerView() {
        binding?.rvBookingList?.layoutManager= LinearLayoutManager(requireContext())
        val showlist=ArrayList<ModelBookingLists>()
        showlist.add(ModelBookingLists("PARKING ONGOING","Easkarton Shopping Mall", "$7","10, Bilpar Road, Sylhet","Thu 23 Jan","10:00","Thu 27 Jan","12:00"))
        showlist.add(ModelBookingLists("PARKING COMPLETED","Hillview Hotel MC", "$5","Vathalia Lamabazar, Sylhet","Thu 23 Jan","10:00","Thu 27 Jan","12:00"))
        showlist.add(ModelBookingLists("PARKING ONGOING","Easkarton Shopping Mall", "$7","10, Bilpar Road, Sylhet","Thu 23 Jan","10:00","Thu 27 Jan","12:00"))

        val adopter= AdapterBookingLists(){position, item ->
            val intent= Intent(requireContext(),BookingDetailActivity::class.java)
            intent.putExtra("bookingObject", item)
            startActivity(intent)
        }
        adopter.setDate(showlist)
        binding?.rvBookingList?.adapter=adopter
    }

    private fun initTopBar() {
        binding?.topbarBooking?.ivImageLeft?.setVisibility(View.GONE)
        binding?.topbarBooking?.tvTopBarContent?.setText("My Booking")
        binding?.topbarBooking?.ivImageRight?.setVisibility(View.GONE)

    }
}