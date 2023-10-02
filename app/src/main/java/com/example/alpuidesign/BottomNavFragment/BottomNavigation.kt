package com.example.alpuidesign.BottomNavFragment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.alpuidesign.AdapterClasses.AdapterBottomNav
import com.example.alpuidesign.Fragments.HomeFragment
import com.example.alpuidesign.Fragments.MyBookingFragment
import com.example.alpuidesign.Fragments.NotificationFragment
import com.example.alpuidesign.Fragments.SettingFragment
import com.example.alpuidesign.ModelClasses.ModelBottomNav
import com.example.alpuidesign.R

class BottomNavigation : AppCompatActivity() {
    lateinit var rvBottomNav: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
        rvBottomNav = findViewById(R.id.rvBottomNav)

        var itemsBtm = arrayListOf<ModelBottomNav>(
            ModelBottomNav(
                R.drawable.home,
                R.drawable.home1,
            ),

            ModelBottomNav(
                R.drawable.notification,
                R.drawable.notification1,
            ),

            ModelBottomNav(
                R.drawable.time,
                R.drawable.time1,
            ),

            ModelBottomNav(
                R.drawable.setting,
                R.drawable.setting1,
            )
        )

        rvBottomNav.adapter = AdapterBottomNav(itemsBtm, this)
        { prePosition: Int, selectedPost: Int, item: ModelBottomNav ->

            if (selectedPost == 0) {
                supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment())
                    .commit()
                true
            }

            if (selectedPost == 1) {
                supportFragmentManager.beginTransaction().replace(R.id.container, NotificationFragment())
                    .commit()
                true
            }

            if (selectedPost == 2) {
                supportFragmentManager.beginTransaction().replace(R.id.container, MyBookingFragment())
                    .commit()
                true
            }

            if (selectedPost == 3) {
                supportFragmentManager.beginTransaction().replace(R.id.container, SettingFragment())
                    .commit()
                true
            }

        }
    }
}