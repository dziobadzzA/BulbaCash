package com.service.bulbacash.domain.repositories

import com.service.bulbacash.domain.models.Rate

interface CourseDayRepository {
    suspend fun getRateToday(id:Int): Rate?
    suspend fun getRateDate(id: Int, onDate:String):Rate?
}