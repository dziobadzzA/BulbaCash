package com.service.bulbacash.di

import com.service.bulbacash.data.db.dao.BulbaCashDAO
import com.service.bulbacash.data.mappers.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    fun provideCurrencyPojoToCurrency(mapHelper:Helper): CurrencyPojoToCurrency {
        return CurrencyPojoToCurrency(mapHelper = mapHelper)
    }

    @Provides
    fun provideRatePojoToRate(): RatePojoToRate {
        return RatePojoToRate()
    }

    @Provides
    fun provideRateShortPojoToRateShort(templateEqualsValue: TemplateEqualsValue):
            RateShortPojoToRateShort {
        return RateShortPojoToRateShort(templateEqualsValue)
    }

    @Provides
    fun provideRateEntityToRate(): RateEntityToRate {
        return RateEntityToRate()
    }

    @Provides
    fun provideCurrencyEntityToCurrency(): CurrencyEntityToCurrency {
        return CurrencyEntityToCurrency()
    }

    @Provides
    fun provideCurrencyToCurrencyEntity(): CurrencyToCurrencyEntity {
        return CurrencyToCurrencyEntity()
    }

    @Provides
    fun provideBucketsEntityToBucketRate(
        bulbaCashDAO: BulbaCashDAO,
        mapperRateEntityToRate: RateEntityToRate): BucketsEntityToBucketRate {

        return BucketsEntityToBucketRate(
            bulbaCashDAO = bulbaCashDAO,
            mapperRateEntityToRate = mapperRateEntityToRate
        )

    }

    @Provides
    fun provideBucketsRateToBucketEntity(): BucketsRateToBucketEntity {
        return BucketsRateToBucketEntity()
    }

}