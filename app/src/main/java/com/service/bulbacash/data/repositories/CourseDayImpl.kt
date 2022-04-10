package com.service.bulbacash.data.repositories

import com.service.bulbacash.data.api.BankApiService
import com.service.bulbacash.data.api.pojo.RatePojo
import com.service.bulbacash.domain.models.Rate
import com.service.bulbacash.domain.repositories.CourseDayRepository
import javax.inject.Inject

class CourseDayImpl @Inject constructor(
    private val bankApi: BankApiService,
    private val mapRatePojo: RatePojo
):CourseDayRepository{

    override suspend fun getRateToday(id: Int): Rate {
        TODO("Not yet implemented")
    }

    override suspend fun getRateDate(id: Int, onDate: String): Rate {
        TODO("Not yet implemented")
    }

}