package com.example.alpuidesign.AdapterClasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alpuidesign.ModelClasses.OnBoardingItems

import com.example.alpuidesign.R

class OnBoardingAdapter (private val onboardingItems: List<OnBoardingItems>) :
    RecyclerView.Adapter<OnBoardingAdapter.OnboardingViewHolder>() {

    inner class OnboardingViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.ivOnboarding)
        private val titleTextView: TextView = itemView.findViewById(R.id.tvTitle)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.tvDescription)

        fun bind(item: OnBoardingItems) {
            imageView.setImageResource(item.image)
            titleTextView.text = item.title
            descriptionTextView.text = item.description
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_onboarding, parent, false)
        return OnboardingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        val item = onboardingItems[position]
        holder.bind(item)
    }

    override fun getItemCount() = onboardingItems.size
}