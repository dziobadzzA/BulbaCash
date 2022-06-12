package com.service.bulbacash.domain.usecases

import com.service.bulbacash.domain.repositories.CurrentBucketsRepository

class GetBucketsUseCase (private val repository: CurrentBucketsRepository) {
    suspend operator fun invoke() = repository.getBuckets()
}