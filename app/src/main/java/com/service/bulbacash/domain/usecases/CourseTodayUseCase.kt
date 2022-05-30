package com.service.bulbacash.domain.usecases

import com.service.bulbacash.domain.repositories.CourseDayRepository

class CourseTodayUseCase(private val repository: CourseDayRepository) {
    suspend operator fun invoke(id:Int) = repository.getRateToday(id = id)
}