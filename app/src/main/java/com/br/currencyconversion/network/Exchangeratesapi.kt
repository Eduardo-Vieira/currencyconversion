package com.br.currencyconversion.network

import com.br.currencyconversion.network.model.Latest
import retrofit2.http.GET

interface Exchangeratesapi {
    @GET("latest")
    suspend fun getLatest(): Latest
}