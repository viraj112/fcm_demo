package com.neosoft.myapplication.navigation


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.neosoft.myapplication.R
import kotlinx.android.synthetic.main.fragment_home.*


class SplashFragment : Fragment(R.layout.fragment_splashe) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splashe, container, false)

        Handler(Looper.myLooper()!!).postDelayed({
            if(UserLoginInfo.user ==null){
                findNavController()
                    .navigate(R.id.action_splashFragment_to_dashboard_graph,
                        null,
                        NavOptions.Builder()
                            .setPopUpTo(R.id.splashFragment,
                                true).build()
                    )

            }


        }, 3000)
        return view
    }
}