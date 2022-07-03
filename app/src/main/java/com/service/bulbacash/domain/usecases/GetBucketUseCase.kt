package com.service.bulbacash.domain.usecases

import com.service.bulbacash.domain.repositories.CurrentBucketsRepository

class GetBucketUseCase (private val repository: CurrentBucketsRepository) {
    suspend operator fun invoke(id: Long) = repository.getBucket(id=id)
}