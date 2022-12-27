package com.neosoft.myapplication


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_view_transaction.*


class ViewTransactionFragment : Fragment(R.layout.fragment_view_transaction) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnTest.setOnClickListener {
            val action =
                ViewTransactionFragmentDirections.actionViewTransactionFragmentToSendCashFragment(amt = "200")
            findNavController().navigate(action)
        }

    }

}