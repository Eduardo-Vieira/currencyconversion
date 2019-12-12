package com.br.currencyconversion.ui.fragment.login


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.br.currencyconversion.R
import com.br.currencyconversion.database.AppSharedPreferences
import com.br.currencyconversion.ui.fragment.currencyconversion.CurrencyConversionFragmentDirections
import kotlinx.android.synthetic.main.fragment_login.*
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {

    private val sharedPreferences: AppSharedPreferences by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.activity?.title = "Login to your app"
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListener()
    }

    private fun onClickListener(){
        btn_logIn.setOnClickListener { setFirstAccess() }
        btn_logIn_facebook.setOnClickListener { setFirstAccess() }
        btn_logIn_twitter.setOnClickListener { setFirstAccess() }
        btn_logIn_google.setOnClickListener { setFirstAccess() }
    }

    private fun setFirstAccess(){
        context?.let {
            sharedPreferences.setFirstAccess(it,true)
            this.findNavController().navigate(R.id.currencyConversionFragment)
        }
    }


}
