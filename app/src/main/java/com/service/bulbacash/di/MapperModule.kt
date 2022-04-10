package com.service.bulbacash.di

import com.service.bulbacash.data.mappers.CurrencyPojoToCurrency
import com.service.bulbacash.data.mappers.RatePojoToRate
import com.service.bulbacash.data.mappers.RateShortPojoToRateShort
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun provideCurrencyPojoToCurrency(): CurrencyPojoToCurrency {
        return CurrencyPojoToCurrency()
    }

    @Provides
    fun provideRatePojoToRate(): RatePojoToRate {
        return RatePojoToRate()
    }

    @Provides
    fun provideRateShortPojoToRateShort(): RateShortPojoToRateShort {
        return RateShortPojoToRateShort()
    }

}