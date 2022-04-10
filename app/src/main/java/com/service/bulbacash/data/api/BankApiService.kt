package com.service.bulbacash.data.api

import com.service.bulbacash.data.api.pojo.CurrencyPojo
import retrofit2.http.GET
import retrofit2.http.Path

interface BankApiService {

    /**
     * Get all currency
     */
    @GET("exrates/currencies")
    suspend fun getCurrency(): List<CurrencyPojo?>

    /**
     * Get all current currency
     */
    @GET("exrates/currencies/{id}")
    suspend fun getCurrentCurrency(@Path("id") id:Int): CurrencyPojo?
}