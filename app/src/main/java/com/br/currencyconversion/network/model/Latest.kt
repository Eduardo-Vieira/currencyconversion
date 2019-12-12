package com.br.currencyconversion.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Latest {
    @SerializedName("rates")
    @Expose
    var rates: HashMap<String,String>? = null
    @SerializedName("base")
    @Expose
    var base: String? = null
    @SerializedName("date")
    @Expose
    var date: String? = null

}

data class Rates (
    @SerializedName("CAD")
    @Expose
    var cAD: Double? = null,
    @SerializedName("HKD")
    @Expose
    var hKD: Double? = null,
    @SerializedName("ISK")
    @Expose
    var iSK: Double? = null,
    @SerializedName("PHP")
    @Expose
    var pHP: Double? = null,
    @SerializedName("DKK")
    @Expose
    var dKK: Double? = null,
    @SerializedName("HUF")
    @Expose
    var hUF: Double? = null,
    @SerializedName("CZK")
    @Expose
    var cZK: Double? = null,
    @SerializedName("AUD")
    @Expose
    var aUD: Double? = null,
    @SerializedName("RON")
    @Expose
    var rON: Double? = null,
    @SerializedName("SEK")
    @Expose
    var sEK: Double? = null,
    @SerializedName("IDR")
    @Expose
    var iDR: Double? = null,
    @SerializedName("INR")
    @Expose
    var iNR: Double? = null,
    @SerializedName("BRL")
    @Expose
    var bRL: Double? = null,
    @SerializedName("RUB")
    @Expose
    var rUB: Double? = null,
    @SerializedName("HRK")
    @Expose
    var hRK: Double? = null,
    @SerializedName("JPY")
    @Expose
    var jPY: Double? = null,
    @SerializedName("THB")
    @Expose
    var tHB: Double? = null,
    @SerializedName("CHF")
    @Expose
    var cHF: Double? = null,
    @SerializedName("SGD")
    @Expose
    var sGD: Double? = null,
    @SerializedName("PLN")
    @Expose
    var pLN: Double? = null,
    @SerializedName("BGN")
    @Expose
    var bGN: Double? = null,
    @SerializedName("TRY")
    @Expose
    var tRY: Double? = null,
    @SerializedName("CNY")
    @Expose
    var cNY: Double? = null,
    @SerializedName("NOK")
    @Expose
    var nOK: Double? = null,
    @SerializedName("NZD")
    @Expose
    var nZD: Double? = null,
    @SerializedName("ZAR")
    @Expose
    var zAR: Double? = null,
    @SerializedName("USD")
    @Expose
    var uSD: Double? = null,
    @SerializedName("MXN")
    @Expose
    var mXN: Double? = null,
    @SerializedName("ILS")
    @Expose
    var iLS: Double? = null,
    @SerializedName("GBP")
    @Expose
    var gBP: Double? = null,
    @SerializedName("KRW")
    @Expose
    var kRW: Double? = null,
    @SerializedName("MYR")
    @Expose
    var mYR: Double? = null
)