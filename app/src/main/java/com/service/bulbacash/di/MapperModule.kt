package com.service.bulbacash.di

import com.service.bulbacash.data.mappers.CurrencyMapperToCurrency
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun provideCurrencyPojoToCurrency(): CurrencyMapperToCurrency {
        return CurrencyMapperToCurrency()
    }

}