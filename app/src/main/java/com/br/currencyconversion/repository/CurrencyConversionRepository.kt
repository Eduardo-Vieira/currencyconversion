package com.br.currencyconversion.repository

import com.br.currencyconversion.database.dao.HistoricDao
import com.br.currencyconversion.database.model.Historic
import com.br.currencyconversion.network.Exchangeratesapi

class CurrencyConversionRepository(
    private val remote: Exchangeratesapi,
    private val local: HistoricDao
) {
    suspend fun getLatest() = remote.getLatest()

    suspend fun insert(historic:Historic){
        local.insert(historic)
    }

}