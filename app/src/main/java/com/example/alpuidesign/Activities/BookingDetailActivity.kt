package com.example.alpuidesign.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.alpuidesign.ModelClasses.ModelBookingLists
import com.example.alpuidesign.R

class BookingDetailActivity : AppCompatActivity() {
    var bookingObject:ModelBookingLists ?=null
    lateinit var ivBackArrow:ImageView
    lateinit var tvBookingStatus:TextView
    lateinit var tvLocationName:TextView
    lateinit var tvAddress:TextView
    lateinit var tvBookingStartDay: TextView
    lateinit var tvBookingStartTime:TextView
    lateinit var tvBookingEndDay:TextView
    lateinit var tvBookingEndTime:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_detail)
        bookingObject = intent.getSerializableExtra("bookingObject") as ModelBookingLists

        findView()
        getBookingData()
        OnClickListener()
    }

    private fun OnClickListener()
    {
        ivBackArrow.setOnClickListener {
            onBackPressed()
        }
    }

    private fun getBookingData() {
        tvBookingStatus.setText(bookingObject?.tvBookingStatus)
        tvLocationName.setText(bookingObject?.tvLocationName)
        tvAddress.setText(bookingObject?.tvAddress)
        tvBookingStartDay.setText(bookingObject?.tvBookingStartDay)
        tvBookingStartTime.setText(bookingObject?.tvBookingStartTime)
        tvBookingEndDay.setText(bookingObject?.tvBookingEndDay)
        tvBookingEndTime.setText(bookingObject?.tvBookingEndTime)
    }

    private fun findView() {
        tvBookingStatus=findViewById(R.id.tvBookingStatus)
        tvLocationName=findViewById(R.id.tvLocationName)
        tvAddress=findViewById(R.id.tvAddress)
        tvBookingStartDay=findViewById(R.id.tvBookingStartDay)
        tvBookingStartTime=findViewById(R.id.tvBookingStartTime)
        tvBookingEndDay=findViewById(R.id.tvBookingEndDay)
        tvBookingEndTime=findViewById(R.id.tvBookingEndTime)
        ivBackArrow=findViewById(R.id.ivBackArrow)


    }


}