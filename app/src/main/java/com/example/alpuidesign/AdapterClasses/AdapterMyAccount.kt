package com.example.alpuidesign.AdapterClasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alpuidesign.ModelClasses.ModelBookingLists
import com.example.alpuidesign.ModelClasses.ModelMyAccount
import com.example.alpuidesign.R

class AdapterMyAccount(val callBack: (position: Int, item: ModelMyAccount) -> Unit):RecyclerView.Adapter<AdapterMyAccount.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMyAccount.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.items_myaccount,parent,false)
        return AdapterMyAccount.ViewHolder(view)
    }

    lateinit var arrMessage:ArrayList<ModelMyAccount>
    fun setDate(list: ArrayList<ModelMyAccount>)
    {
        arrMessage=list
    }

    override fun getItemCount(): Int {
        return arrMessage.size
    }

    override fun onBindViewHolder(holder: AdapterMyAccount.ViewHolder, position: Int)
    {
        holder.tvAccountList.text=arrMessage[position].tvAccountList
        holder.ivAccountIcon.setImageResource(arrMessage[position].ivAccountIcon)
    }

    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView)
    {
        val tvAccountList:TextView=itemView.findViewById(R.id.tvAccountList)
        val ivAccountIcon:ImageView=itemView.findViewById(R.id.ivAccountIcon)
    }


    }