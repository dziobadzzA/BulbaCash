package com.service.bulbacash.domain.repositories

import com.service.bulbacash.domain.models.BucketRate

interface CurrentBucketsRepository {
    suspend fun addBucket(bucketRate: BucketRate): Boolean
    suspend fun getBuckets():List<BucketRate>
}