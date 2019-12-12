package com.br.currencyconversion.repository

import com.br.currencyconversion.database.dao.HistoricDao
import com.br.currencyconversion.database.model.Historic

class HistoricRepository(private val local: HistoricDao) {

    suspend fun getHistoricLocal(): List<Historic> = local.getHistoricLocal()
}