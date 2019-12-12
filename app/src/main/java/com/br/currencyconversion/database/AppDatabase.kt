package com.br.currencyconversion.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.br.currencyconversion.database.converter.ConversorBigDecimal
import com.br.currencyconversion.database.dao.HistoricDao
import com.br.currencyconversion.database.model.Historic

@Database(entities = arrayOf(Historic::class), version = 1, exportSchema = false)
@TypeConverters(ConversorBigDecimal::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun historicDao(): HistoricDao

}