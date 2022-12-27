package com.neosoft.myapplication


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_choose_receiver.*


class ChooseReceiverFragment : Fragment(R.layout.fragment_choose_receiver) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_next.setOnClickListener {

            val receiverName = et_receiver_name.text.toString()
            val action = ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToSendCashFragment(receiverName,"300")
            findNavController().navigate(action)
        }

        getBackStackData<String>("key") { data ->
            Log.d("GET", "onViewCreated: $data")
        }

    }

    fun <T : Any> Fragment.getBackStackData(key: String, result: (T) -> (Unit)) {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)?.observe(viewLifecycleOwner) {
            result(it)
        }
    }
}