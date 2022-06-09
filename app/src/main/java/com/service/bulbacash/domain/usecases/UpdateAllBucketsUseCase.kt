package com.service.bulbacash.domain.usecases

import com.service.bulbacash.domain.repositories.GetBucketsRepository

class UpdateAllBucketsUseCase(private val repository: GetBucketsRepository) {
    suspend operator fun invoke() = repository.getUpdateCurrency()
}