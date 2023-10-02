package com.example.alpuidesign.OnBoardingActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.alpuidesign.AdapterClasses.OnBoardingAdapter
import com.example.alpuidesign.BottomNavFragment.BottomNavigation
import com.example.alpuidesign.ModelClasses.OnBoardingItems
import com.example.alpuidesign.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var onboardingRecyclerView: RecyclerView
    private lateinit var skipButton: TextView
    lateinit var dotsIndicator: SpringDotsIndicator
    lateinit var btnNext:TextView

    val onboardingItems = listOf(
        OnBoardingItems(
            R.drawable.sample,
            "Welcome to Park Here",
            "Find the best possible parking space nearby your desired destination."
        ),
        OnBoardingItems(
            R.drawable.sample,
            "Get started",
            "Chat with people that match your vibe with \n" +
                    "just one tap.."
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        findView()
        onClickListener()
        addViewPager()
    }

    private fun onClickListener() {
       btnNext.setOnClickListener {
           val currentItem = viewPager.currentItem
           if(currentItem==onboardingItems.size-1)
           {
               startActivity(Intent(this,BottomNavigation::class.java))
               finish()
           }
           else
           viewPager.setCurrentItem(currentItem + 1, true)
       }
    }

    private fun findView() {
        viewPager = findViewById(R.id.view_pager)
        onboardingRecyclerView = findViewById(R.id.onboardingRecyclerView)
        skipButton = findViewById(R.id.tvSkip)
        btnNext=findViewById(R.id.btnNext)
        dotsIndicator=findViewById(R.id.dots_indicator)
    }

    private fun addViewPager()
    {
        viewPager.adapter = OnBoardingAdapter(onboardingItems)
        dotsIndicator.attachTo(viewPager)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)


                if (position == onboardingItems.size - 1) {

                }

            }
        })

    }

}