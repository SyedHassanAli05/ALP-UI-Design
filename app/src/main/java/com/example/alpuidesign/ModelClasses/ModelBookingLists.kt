package com.example.alpuidesign.ModelClasses

import java.io.Serializable

class ModelBookingLists(val tvBookingStatus:String, val tvLocationName:String, val tvPrice:String,
                        val tvAddress:String,
                        val tvBookingStartDay:String, val tvBookingStartTime:String,
                        val tvBookingEndDay:String, val tvBookingEndTime:String ): Serializable
{
}