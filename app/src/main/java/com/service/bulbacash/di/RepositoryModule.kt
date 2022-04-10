package com.service.bulbacash.di

import com.service.bulbacash.data.api.BankApiService
import com.service.bulbacash.data.mappers.RatePojoToRate
import com.service.bulbacash.data.repositories.CourseDayImpl
import com.service.bulbacash.domain.repositories.CourseDayRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideLoginRepository(
        bankApi: BankApiService,
        mapRatePojoToRate: RatePojoToRate
    ): CourseDayRepository {
        return CourseDayImpl(
            bankApi = bankApi,
            mapRatePojoToRate = mapRatePojoToRate
        )
    }

}