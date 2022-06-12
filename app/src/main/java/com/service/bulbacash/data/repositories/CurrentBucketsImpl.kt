package com.service.bulbacash.data.repositories

import com.service.bulbacash.data.db.dao.BulbaCashDAO
import com.service.bulbacash.data.db.entity.BucketsEntity
import com.service.bulbacash.data.mappers.BucketsEntityToBucketRate
import com.service.bulbacash.data.mappers.BucketsRateToBucketEntity
import com.service.bulbacash.domain.models.BucketRate
import com.service.bulbacash.domain.repositories.CurrentBucketsRepository
import javax.inject.Inject

class CurrentBucketsImpl @Inject constructor(
    private val bulbaCashDAO: BulbaCashDAO,
    private val mapperBucketsEntityToBucketRate: BucketsEntityToBucketRate,
    private val mapperBucketsRateToBucketEntity: BucketsRateToBucketEntity
    ): CurrentBucketsRepository {

    override suspend fun addBucket(firstID: Long, secondID: Long): Boolean {
        return try {
            bulbaCashDAO.insertBucket(BucketsEntity(
                firstRate = firstID,
                secondRate = secondID
            ))
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun getBuckets(): List<BucketRate> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteBucket(bucketRate: BucketRate): Boolean {
        TODO("Not yet implemented")
    }

}