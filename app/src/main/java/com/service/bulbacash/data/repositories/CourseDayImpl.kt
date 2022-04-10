package com.service.bulbacash.data.repositories

import com.service.bulbacash.data.api.BankApiService
import com.service.bulbacash.data.mappers.RatePojoToRate
import com.service.bulbacash.domain.models.Rate
import com.service.bulbacash.domain.repositories.CourseDayRepository
import javax.inject.Inject

class CourseDayImpl @Inject constructor(
    private val bankApi: BankApiService,
    private val mapRatePojoToRate: RatePojoToRate
):CourseDayRepository{

    override suspend fun getRateToday(id: Int): Rate? {
        return bankApi.getRateToday(id)?.let { mapRatePojoToRate.map(it) }
    }

    override suspend fun getRateDate(id: Int, onDate: String): Rate? {
        TODO("Not yet implemented")
    }

}