package com.service.bulbacash.data.repositories

import com.service.bulbacash.data.api.BankApiService
import com.service.bulbacash.data.mappers.RateShortPojoToRateShort
import com.service.bulbacash.domain.models.RateShort
import com.service.bulbacash.domain.repositories.CourseGraphRepository
import javax.inject.Inject

class CoursePeriodImpl @Inject constructor(
    private val bankApi: BankApiService,
    private val mapRateShortPojoToRateShort: RateShortPojoToRateShort
): CourseGraphRepository {

    override suspend fun getRateShortPeriod(
        id: Int,
        onStartDate: String,
        onEndDate: String
    ): List<RateShort> {
       return mapRateShortPojoToRateShort.mapList(bankApi.getRateShort(id = id,
           startDate = onStartDate, endDate = onStartDate)
       )
    }

}