package com.br.currencyconversion.ui.fragment.historic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.currencyconversion.database.model.Historic
import com.br.currencyconversion.repository.HistoricRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoricViewModel(private val repository: HistoricRepository):ViewModel() {

    var historicList = MutableLiveData<List<Historic>>()

    fun getHistoricList(){
        viewModelScope.launch {
            val mHistoricLocal = withContext(Dispatchers.IO) {
                repository.getHistoricLocal()
            }
            historicList.value = mHistoricLocal
        }
    }

}