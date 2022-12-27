package com.neosoft.myapplication.navigation


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.neosoft.myapplication.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment(R.layout.fragment_settings) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_default_amount.setText( SampleData.defaultValue.value.toString())
        btn_save_default_amount.setOnClickListener {
            val defaultAmount = et_default_amount.text.toString().toLong()
            SampleData.defaultValue.value = defaultAmount
        }



    }
}


