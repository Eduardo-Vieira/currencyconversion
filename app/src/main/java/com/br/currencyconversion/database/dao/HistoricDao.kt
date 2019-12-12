package com.br.currencyconversion.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.br.currencyconversion.database.model.Historic

@Dao
interface HistoricDao {
    @Query("SELECT * from tb_historic " +
            "where current_currency || current_currency_value || " +
            "currency_converter || currency_converter_value like :query ORDER BY id ASC")
    suspend fun getHistoricLocal(query:String?): List<Historic>

    @Insert
    suspend fun insert(userLocal: Historic)

    @Query("DELETE FROM tb_historic")
    suspend fun deleteAll()
}