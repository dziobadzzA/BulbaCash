package com.service.bulbacash.di

import com.service.bulbacash.domain.models.Currency
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperCountries {

    fun mapperCurrencyList(list: List<Currency>): List<String> {
        val mapList = mutableListOf<String>()
        for (item in list)
            mapList.add(item.Cur_Name)
        return mapList.toList()
    }

    @Provides
    fun provideMapperCountries(): MapperCountries = MapperCountries

}