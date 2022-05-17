package com.service.bulbacash.domain.repositories

import com.service.bulbacash.domain.models.RateShort

interface CourseGraphRepository {
    suspend fun getRateShortPeriod (id: Int, onStartDate:String, onEndDate:String): List<RateShort>
}