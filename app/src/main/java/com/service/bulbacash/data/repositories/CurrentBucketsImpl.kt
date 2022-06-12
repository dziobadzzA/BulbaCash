package com.service.bulbacash.data.repositories

import com.service.bulbacash.domain.models.BucketRate
import com.service.bulbacash.domain.repositories.CurrentBucketsRepository
import javax.inject.Inject

class CurrentBucketsImpl @Inject constructor(): CurrentBucketsRepository {
    override suspend fun addBucket(bucketRate: BucketRate): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getBuckets(): List<BucketRate> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucket(bucketRate: BucketRate): Boolean {
        TODO("Not yet implemented")
    }
}