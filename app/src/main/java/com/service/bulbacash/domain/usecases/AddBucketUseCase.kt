package com.service.bulbacash.domain.usecases

import com.service.bulbacash.domain.models.BucketRate
import com.service.bulbacash.domain.repositories.CurrentBucketsRepository

class AddBucketUseCase (private val repository: CurrentBucketsRepository) {
    suspend operator fun invoke(bucketRate: BucketRate) = repository.addBucket(
        bucketRate = bucketRate
    )
}