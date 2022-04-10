package com.service.bulbacash.domain.usecases

import com.service.bulbacash.domain.repositories.CourseDayRepository

class CourseDateUseCase(private val repository: CourseDayRepository) {
    suspend operator fun invoke(id:Int, onDate:String) = repository.getRateDate(id = id, onDate = onDate)
}