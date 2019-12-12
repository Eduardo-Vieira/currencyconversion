package com.br.currencyconversion.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.br.currencyconversion.database.model.Historic

@Dao
interface HistoricDao {
    @Query("SELECT * from tb_historic ORDER BY id ASC")
    suspend fun getHistoricLocal(): List<Historic>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(userLocal: Historic)

    @Query("DELETE FROM tb_historic")
    suspend fun deleteAll()
}