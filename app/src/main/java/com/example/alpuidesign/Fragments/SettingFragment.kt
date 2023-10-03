package com.example.alpuidesign.Fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alpuidesign.AdapterClasses.AdapterMyAccount
import com.example.alpuidesign.ModelClasses.ModelMyAccount
import com.example.alpuidesign.R
import com.example.alpuidesign.databinding.ActivityHomeFragmentBinding
import com.example.alpuidesign.databinding.ActivitySettingFragmentBinding

class SettingFragment : Fragment() {
    var binding:ActivitySettingFragmentBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<ActivitySettingFragmentBinding?>(inflater,R.layout.activity_setting_fragment, container, false)
        return binding?.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTopBar()
        setRecycleView()
    }

    private fun setRecycleView() {
        binding?.rvMyAccount?.layoutManager=LinearLayoutManager(requireContext())
        val showList=ArrayList<ModelMyAccount>()
        showList.add(ModelMyAccount(R.drawable.ic_outline_person_24,"My Profile"))
        showList.add(ModelMyAccount(R.drawable.ic_baseline_payment_24,"Payment Passes"))
        showList.add(ModelMyAccount(R.drawable.help,"Help"))
        showList.add(ModelMyAccount(R.drawable.icons8_adjust_24,"Settings"))
        showList.add(ModelMyAccount(R.drawable.icons8_note_50,"Legals"))

        val adopter=AdapterMyAccount(){position, item ->

        }
        adopter.setDate(showList)
        binding?.rvMyAccount?.adapter=adopter
    }


    private fun initTopBar() {
        binding?.topbarAccount?.ivImageLeft?.setVisibility(View.GONE)
        binding?.topbarAccount?.tvTopBarContent?.setText("My Account")
        binding?.topbarAccount?.ivImageRight?.setVisibility(View.GONE)

    }
}