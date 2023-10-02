package com.example.alpuidesign.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.alpuidesign.ModelClasses.ModelBookingLists
import com.example.alpuidesign.R

class BookingDetailActivity : AppCompatActivity() {
    var bookingObject:ModelBookingLists ?=null
    lateinit var tvBookingStatus:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_detail)
        bookingObject = intent.getSerializableExtra("bookingObject") as ModelBookingLists

        findview()
    }

    private fun findview() {
        tvBookingStatus=findViewById(R.id.tvBookingStatus)

        tvBookingStatus.setText(bookingObject?.tvBookingStatus)
    }


}