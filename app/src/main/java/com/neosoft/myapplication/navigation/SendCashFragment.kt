package com.neosoft.myapplication.navigation


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.neosoft.myapplication.R
import kotlinx.android.synthetic.main.fragment_send_cash.*
import kotlinx.android.synthetic.main.fragment_settings.*


class SendCashFragment : Fragment(R.layout.fragment_send_cash) {

    val args: SendCashFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_receiver.text = args.receiverName
        //   et_amount.setText(args.amt)
        et_amount.setText(SampleData.defaultValue.value.toString())

        SampleData.defaultValue.observe(viewLifecycleOwner) {
            et_amount.setText(it.toString())
        }
        btn_done.setOnClickListener {
            //setBackStackData("key", "test")

            val action = SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
            findNavController().navigate(action)
        }

        btn_send.setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogFragment(
                args.receiverName,
                "100"
            )
            findNavController().navigate(action)
        }

        btn_cancel.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment, true)
        }


    }


    fun <T : Any> Fragment.setBackStackData(key: String, data: T, doBack: Boolean = true) {
        findNavController().previousBackStackEntry?.savedStateHandle?.set(key, data)
        if (doBack)
            findNavController().popBackStack()
    }


}