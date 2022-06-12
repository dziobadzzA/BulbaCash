package com.service.bulbacash.domain.usecases

import com.service.bulbacash.domain.models.BucketRate
import com.service.bulbacash.domain.repositories.CurrentBucketsRepository

class DeleteBucketUseCase (private val repository: CurrentBucketsRepository) {
    suspend operator fun invoke(bucketRate: BucketRate) = repository.deleteBucket(
        bucketRate = bucketRate
    )
}