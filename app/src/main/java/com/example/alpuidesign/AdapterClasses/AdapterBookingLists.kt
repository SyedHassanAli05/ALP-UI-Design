package com.example.alpuidesign.AdapterClasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alpuidesign.ModelClasses.ModelBookingLists
import com.example.alpuidesign.R

class AdapterBookingLists(val callBack: (position: Int, item: ModelBookingLists) -> Unit):RecyclerView.Adapter<AdapterBookingLists.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterBookingLists.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.items_mybooking,parent,false)
        return ViewHolder(view)
    }

    lateinit var arrMessage:ArrayList<ModelBookingLists>
    fun setDate(list: ArrayList<ModelBookingLists>)
    {
        arrMessage=list
    }

    override fun getItemCount(): Int {
        return arrMessage.size
    }

    override fun onBindViewHolder(holder: AdapterBookingLists.ViewHolder, position: Int) {

        holder.tvBookingStatus.text=arrMessage[position].tvBookingStatus
        holder.tvAddress.text=arrMessage[position].tvAddress
        holder.tvPrice.text=arrMessage[position].tvPrice
        holder.tvLocationName.text=arrMessage[position].tvLocationName
        //holder.ivCalender.setImageResource(arrMessage[position].)
        holder.tvBookingStartDay.text=arrMessage[position].tvBookingStartDay
        holder.tvBookingStartTime.text=arrMessage[position].tvBookingStartTime
        holder.tvBookingEndDay.text=arrMessage[position].tvBookingEndDay
        holder.tvBookingEndTime.text=arrMessage[position].tvBookingEndTime

        holder.itemView.setOnClickListener {
            callBack(position,arrMessage[position])
        }
    }

    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView)
    {
        val tvBookingStatus: TextView =itemView.findViewById(R.id.tvBookingStatus)
        val tvLocationName: TextView =itemView.findViewById(R.id.tvLocationName)
        val tvPrice: TextView =itemView.findViewById(R.id.tvPrice)
        val tvAddress: TextView =itemView.findViewById(R.id.tvAddress)
        val  ivCalender: ImageView =itemView.findViewById(R.id.ivCalender)
        val tvBookingStartDay: TextView =itemView.findViewById(R.id.tvBookingStartDay)
        val tvBookingStartTime: TextView =itemView.findViewById(R.id.tvBookingStartTime)
        val tvBookingEndDay: TextView =itemView.findViewById(R.id.tvBookingEndDay)
        val tvBookingEndTime: TextView =itemView.findViewById(R.id.tvBookingEndTime)

    }
}