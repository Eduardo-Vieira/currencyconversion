package com.br.currencyconversion.ui.fragment.currencyconversion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.currencyconversion.database.model.Historic
import com.br.currencyconversion.repository.CurrencyConversionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CurrencyConversionViewModel(
    private val repository: CurrencyConversionRepository
): ViewModel() {

    val ratesKey = MutableLiveData<List<String>>()
    val ratesValue:MutableList<String> = mutableListOf()
    val erro = MutableLiveData<String>()

    fun getLatest(){
        try {
            viewModelScope.launch {
                val latest = withContext(Dispatchers.IO) {
                    repository.getLatest()
                }

                latest.rates?.also {
                    ratesKey.postValue(it.keys.toMutableList())
                    ratesValue.addAll(it.values.toMutableList())
                }

            }
        }catch (e: Throwable){
            erro.value = e.message
        }
    }

    fun getRatesValue(position: Int):String {
        return ratesValue[position]
    }

    fun getRatesKey(position: Int):String {
        return ratesKey.value?.get(position).toString()
    }

    fun insertHistoricLocal(historic: Historic){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.insert(historic)
            }
        }
    }

}