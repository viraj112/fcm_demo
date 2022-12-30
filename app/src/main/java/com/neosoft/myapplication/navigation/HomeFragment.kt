package com.neosoft.myapplication.navigation


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.neosoft.myapplication.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val currentBackStackEntry = findNavController().currentBackStackEntry
        val savedStateHandle = currentBackStackEntry!!.savedStateHandle

        savedStateHandle.getLiveData<Boolean>(LoginFragment.LOGIN_SUCCESSFUL)
            .observe(currentBackStackEntry){
                if(!it){
                    Toast.makeText(requireContext(), "Please login to see your profile", Toast.LENGTH_SHORT).show()

                    val startDest = findNavController().graph.getStartDestination()
                    val navOption = NavOptions.Builder()
                        .setPopUpTo(startDest,true)
                        .build()
                    findNavController().navigate(startDest,null,navOption)
                }
            }

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navCantroller = findNavController()


        if (UserLoginInfo.user ==null){
            Toast.makeText(requireContext(),"Please Login first",Toast.LENGTH_LONG).show()
            navCantroller.navigate(R.id.login_graph)
        }else{
                val username = UserLoginInfo.user!!.userName
                Toast.makeText(requireContext(), "Hi, $username", Toast.LENGTH_SHORT).show()

                val text = username
                tv_welcome.text = text

        }

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