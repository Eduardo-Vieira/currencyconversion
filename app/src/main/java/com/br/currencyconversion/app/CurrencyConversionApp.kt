package com.br.currencyconversion.app

import android.app.Application
import com.br.currencyconversion.id.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CurrencyConversionApp: Application() {
    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@CurrencyConversionApp)
            // modules
            modules(arrayListOf(appModule, viewModelModule,
                networkModule, databaseModule, daoModule))
        }
    }
}