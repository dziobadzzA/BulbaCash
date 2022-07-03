package com.service.bulbacash.domain.usecases

import com.service.bulbacash.domain.repositories.GetBucketsRepository

class GetAllBucketsUseCase(private val repository: GetBucketsRepository) {
    suspend operator fun invoke() = repository.getCurrency()
}