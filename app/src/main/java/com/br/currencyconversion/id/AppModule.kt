package com.br.currencyconversion.id

import androidx.room.Room
import com.br.currencyconversion.database.AppDatabase
import com.br.currencyconversion.network.AuthInterceptor
import com.br.currencyconversion.network.provideExchangeratesapi
import com.br.currencyconversion.network.provideOkHttpClient
import com.br.currencyconversion.network.provideRetrofit
import com.br.currencyconversion.repository.CurrencyConversionRepository
import com.br.currencyconversion.repository.HistoricRepository
import com.br.currencyconversion.ui.fragment.currencyconversion.CurrencyConversionViewModel
import com.br.currencyconversion.ui.fragment.historic.HistoricViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val NOME_BANCO_DE_DADOS = "currencyconversion.db"

val appModule = module {

    factory{ CurrencyConversionRepository(get(),get())}
    factory { HistoricRepository(get()) }
}

val viewModelModule = module {
    viewModel { CurrencyConversionViewModel(get()) }
    viewModel { HistoricViewModel(get()) }
}

val networkModule = module {

    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideExchangeratesapi(get()) }
    single { provideRetrofit(get()) }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            NOME_BANCO_DE_DADOS
        ).build()
    }
}

val daoModule = module {
    single { get<AppDatabase>().historicDao() }
}