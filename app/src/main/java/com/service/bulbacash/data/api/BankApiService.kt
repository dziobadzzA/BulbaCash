package com.service.bulbacash.data.api

import com.service.bulbacash.data.api.pojo.CurrencyPojo
import retrofit2.http.GET

interface BankApiService {
    /**
     * Get all currency
     */
    @GET("exrates/currencies")
    suspend fun getCurrency(): List<CurrencyPojo?>
}