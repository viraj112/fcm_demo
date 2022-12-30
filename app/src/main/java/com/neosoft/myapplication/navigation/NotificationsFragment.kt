package com.neosoft.myapplication.navigation


import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.neosoft.myapplication.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlinx.android.synthetic.main.fragment_settings.*


class NotificationsFragment : Fragment(R.layout.fragment_notifications) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lv_notification.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            getNotififations()
        )


    }

    private fun  getNotififations(): List<String> {
        val notification = mutableListOf<String>()
        for (i in 1..20) {
            notification.add("notification$i")
        }
        return notification

    }
}


