package com.neosoft.myapplication


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_choose_receiver.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_send_cash.*


class SendCashFragment : Fragment(R.layout.fragment_send_cash) {

    val args: SendCashFragmentArgs by navArgs()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_receiver.text = args.receiverName
        et_amount.setText(args.amt)

        btn_done.setOnClickListener {
            setBackStackData("key","test")
        }

        btn_send.setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogFragment(args.receiverName,"100")
            findNavController().navigate(action)
            }


    }


    fun <T : Any> Fragment.setBackStackData(key: String,data : T, doBack : Boolean = true) {
        findNavController().previousBackStackEntry?.savedStateHandle?.set(key, data)
        if(doBack)
            findNavController().popBackStack()
    }








}