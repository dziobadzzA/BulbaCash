package com.service.bulbacash.di

import com.service.bulbacash.data.api.BankApiService
import com.service.bulbacash.data.db.dao.BulbaCashDAO
import com.service.bulbacash.data.mappers.*
import com.service.bulbacash.data.repositories.CourseDayImpl
import com.service.bulbacash.data.repositories.CoursePeriodImpl
import com.service.bulbacash.data.repositories.CurrentBucketsImpl
import com.service.bulbacash.data.repositories.GetAllBucketsImpl
import com.service.bulbacash.domain.repositories.CourseDayRepository
import com.service.bulbacash.domain.repositories.CourseGraphRepository
import com.service.bulbacash.domain.repositories.CurrentBucketsRepository
import com.service.bulbacash.domain.repositories.GetBucketsRepository
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
    fun provideCourseRepository(
        bankApi: BankApiService,
        mapRatePojoToRate: RatePojoToRate
    ): CourseDayRepository {
        return CourseDayImpl(
            bankApi = bankApi,
            mapRatePojoToRate = mapRatePojoToRate
        )
    }

    @Singleton
    @Provides
    fun provideGraphRepository(
        bankApi: BankApiService,
        mapRateShortPojoToRateShort: RateShortPojoToRateShort
    ):CourseGraphRepository {
        return CoursePeriodImpl(
            bankApi = bankApi,
            mapRateShortPojoToRateShort = mapRateShortPojoToRateShort
        )
    }

    @Singleton
    @Provides
    fun provideGetAllBucketsRepository(
        bankApi: BankApiService,
        bulbaCashDAO: BulbaCashDAO,
        mapCurrencyEntityToCurrency: CurrencyEntityToCurrency,
        mapCurrencyPojoToCurrency: CurrencyPojoToCurrency,
        mapCurrencyToCurrencyEntity: CurrencyToCurrencyEntity

    ):GetBucketsRepository {
        return GetAllBucketsImpl(
            bankApi = bankApi,
            bulbaCashDAO = bulbaCashDAO,
            mapCurrencyPojoToCurrency = mapCurrencyPojoToCurrency,
            mapCurrencyEntityToCurrency = mapCurrencyEntityToCurrency,
            mapCurrencyToCurrencyEntity = mapCurrencyToCurrencyEntity
        )
    }

    @Singleton
    @Provides
    fun provideCurrentBucketsRepository(): CurrentBucketsRepository {
        return CurrentBucketsImpl()
    }

}