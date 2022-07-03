package com.service.bulbacash.domain.usecases

import com.service.bulbacash.domain.repositories.CurrentBucketsRepository

class AddBucketUseCase (private val repository: CurrentBucketsRepository) {
    suspend operator fun invoke(firstID: Long, secondID: Long) = repository.addBucket(
        firstID = firstID,
        secondID = secondID
    )
}