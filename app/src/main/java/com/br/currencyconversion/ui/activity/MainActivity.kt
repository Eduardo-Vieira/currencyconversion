package com.br.currencyconversion.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.navigation.findNavController
import com.br.currencyconversion.R
import com.br.currencyconversion.database.AppSharedPreferences
import com.br.currencyconversion.ui.fragment.currencyconversion.CurrencyConversionFragmentDirections
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val sharedPreferences: AppSharedPreferences by inject()

    private val navController by lazy {
        this.findNavController(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.currencyConversionFragment -> setBack(false)
                R.id.loginFragment -> setBack(false)
                else -> setBack(true)
            }
        }
        //sharedPreferences.setFirstAccess(this,false)
    }

    private fun setBack(value:Boolean){
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
        supportActionBar?.setHomeButtonEnabled(value)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> navController.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        val firstAccess = sharedPreferences.getFirstAccess(this)
        if(firstAccess == false) {
            navController
                .navigate(R.id.loginFragment)
        }
    }
}
