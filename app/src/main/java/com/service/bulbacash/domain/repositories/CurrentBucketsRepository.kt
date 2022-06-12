package com.service.bulbacash.domain.repositories

import com.service.bulbacash.domain.models.BucketRate

interface CurrentBucketsRepository {
    suspend fun addBucket(firstID: Long, secondID: Long):Boolean
    suspend fun getBuckets():List<BucketRate>
    suspend fun deleteBucket(bucketRate: BucketRate): Boolean
}