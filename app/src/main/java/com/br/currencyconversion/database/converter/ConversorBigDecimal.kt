package com.br.currencyconversion.database.converter

import java.math.BigDecimal
import androidx.room.TypeConverter

class ConversorBigDecimal {
    @TypeConverter
    fun paraBigDecimal(valor: BigDecimal?): String {
        return valor?.toString() ?: ""
    }

    @TypeConverter
    fun paraString(valor: String?): BigDecimal {
        return valor?.let { BigDecimal(it) } ?: BigDecimal.ZERO
    }
}