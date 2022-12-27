package com.neosoft.myapplication


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navCantroller = findNavController()

        btn_view_balance.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToViewBalenceFragment()
            navCantroller.navigate(action)
        }

        btn_transactions.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToViewTransactionFragment()
            navCantroller.navigate(action)
        }

        btn_send_money.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToChooseReceiverFragment()
            navCantroller.navigate(action)
        }
    }


}