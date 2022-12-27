package com.neosoft.myapplication


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_confirm_dialog.*


class ConfirmDialogFragment : BottomSheetDialogFragment() {
    val args :ConfirmDialogFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_confirm_dialog,container,false                                                            )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_message.text = "Do you want to send this money to ${args.receiverName}"

        btn_yes.setOnClickListener {
            Toast.makeText(requireContext(),args.amount+"Sent Sucessfully",Toast.LENGTH_LONG).show()
            dismiss()
        }
        btn_no.setOnClickListener {
            dismiss()
        }

    }

}