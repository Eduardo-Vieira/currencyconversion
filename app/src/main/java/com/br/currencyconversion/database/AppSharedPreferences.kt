package com.br.currencyconversion.database

import android.content.Context

const val APP_CC_SHARED_PREFERENCES = "app_cc_sp"
const val FIRST_ACCESS_KEY = "primeiroAcesso"

class AppSharedPreferences {
    fun setFirstAccess(context: Context, prefValue:Boolean){
        val appSharedPreferences = context.getSharedPreferences(APP_CC_SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val editor = appSharedPreferences.edit()
        editor.putString(FIRST_ACCESS_KEY, prefValue.toString())
        editor.apply()
    }

    fun getFirstAccess(context:Context):Boolean? {
        val appSharedPreferences = context.getSharedPreferences(APP_CC_SHARED_PREFERENCES, Context.MODE_PRIVATE)
        return appSharedPreferences.getString(FIRST_ACCESS_KEY, "false")?.toBoolean()
    }
}