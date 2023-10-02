package com.example.alpuidesign.AdapterClasses

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.alpuidesign.ModelClasses.ModelBottomNav
import com.example.alpuidesign.R

class AdapterBottomNav(var mData: ArrayList<ModelBottomNav>, var mContext: Context,
                       var callBackSelected: (prePosition: Int, selectedPost: Int, item: ModelBottomNav) -> Unit
) :   RecyclerView.Adapter<AdapterBottomNav.BottomItemVH>() {

    var selected: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomItemVH {
        return BottomItemVH(
            LayoutInflater.from(mContext).inflate(R.layout.items_bottomnav_labels, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AdapterBottomNav.BottomItemVH, position: Int)
    {
        val item = mData[position]
        if (selected == position) {
            holder.imgView.setImageResource(item.icon?:0)
        }

        else
        {
            holder.imgView.setImageResource(item.iconSelected?:0)
        }

        holder.itemView.setOnClickListener {
            val prePos = selected
            selected = position
            notifyItemChanged(position)
            notifyItemChanged(prePos)
            callBackSelected.invoke(prePos, selected, item)
        }
    }

    override fun getItemCount(): Int {
        return mData.count()
    }

    class BottomItemVH(item: View) : RecyclerView.ViewHolder(item) {

        val imgView: ImageView =itemView.findViewById(R.id.ivBtm)

    }
}