package com.service.bulbacash.data.api

import com.service.bulbacash.data.api.pojo.CurrencyPojo
import com.service.bulbacash.data.api.pojo.RatePojo
import com.service.bulbacash.data.api.pojo.RateShortPojo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BankApiService {

    /**
     * Get all currency
     */
    @GET("exrates/currencies")
    suspend fun getCurrency(): List<CurrencyPojo>

    /**
     * Get current currency
     *  @param id Cur_ID
     */
    @GET("exrates/currencies/{id}")
    suspend fun getCurrentCurrency(@Path("id") id:Int): CurrencyPojo?

    /**
     * Get all rates today
     */
    @GET("exrates/rates?periodicity=0")
    suspend fun getRatesToday(): List<RatePojo?>

    /**
     * Get all rates to date
     *  @param ondate Date request
     *  @param periodicity 0 - day, 1 - month
     */
    @GET("exrates/rates")
    suspend fun getRatesDate(
        @Query("ondate") onDate:String,
        @Query("periodicity") periodiCity: Int
    ): List<RatePojo?>

    /**
     * Get rate today
     *  @param id Cur_ID
     */
    @GET("exrates/rates/{id}")
    suspend fun getRateToday(@Path("id") id:Int): RatePojo?

    /**
     * Get rate date
     *  @param id Cur_ID
     *  @param ondate Date request
     */
    @GET("exrates/rates/{id}")
    suspend fun getRateDate(@Path("id") id:Int,
                            @Query("ondate") onDate:String
    ): RatePojo?

    /**
     * Get RatesShort
     *  @param id Cur_ID
     *  @param startDate StartDate request
     *  @param endDate  EndDate request
     */
    @GET("exrates/rates/dynamics/{id}")
    suspend fun getRateShort(@Path("id") id:Int,
                            @Query("startDate") startDate:String,
                            @Query("endDate") endDate:String
    ): List<RateShortPojo>

}