package com.br.currencyconversion.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "tb_historic")
data class Historic(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long?,
    @ColumnInfo(name = "current_currency")
    val currentCurrency: String? = null,
    @ColumnInfo(name = "current_currency_value")
    val currentCurrencyValue: BigDecimal? = null,
    @ColumnInfo(name = "currency_converter")
    val currencyConverter: String? = null,
    @ColumnInfo(name = "currency_converter_value")
    val currencyConverterValue: BigDecimal? = null

)