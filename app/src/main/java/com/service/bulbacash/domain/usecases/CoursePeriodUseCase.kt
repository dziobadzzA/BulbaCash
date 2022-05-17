package com.service.bulbacash.domain.usecases

import com.service.bulbacash.domain.repositories.CourseGraphRepository

class CoursePeriodUseCase(private val repository: CourseGraphRepository) {
    suspend operator fun invoke(id:Int, onStartDate:String, onEndDate:String)
        = repository.getRateShortPeriod(id = id, onStartDate = onStartDate, onEndDate = onEndDate)
}