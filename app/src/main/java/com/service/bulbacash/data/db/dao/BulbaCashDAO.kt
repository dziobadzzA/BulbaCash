package com.service.bulbacash.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.service.bulbacash.data.db.entity.BucketsEntity
import com.service.bulbacash.data.db.entity.RateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BulbaCashDAO {

    // commands for models Rate
    @Insert
    suspend fun insertRate(token: RateEntity)

    @Query("SELECT * FROM rate WHERE id = :id")
    suspend fun getRate(id: Long): Flow<RateEntity>

    @Update
    suspend fun updateToken(rate: RateEntity)

    @Query("DELETE FROM rate WHERE id=:id")
    suspend fun deleteRate(id: Long)

    // commands for models Bucket
    @Insert
    suspend fun insertBucket(bucket: BucketsEntity)

    @Query("SELECT * FROM buckets WHERE id = :id")
    suspend fun getBucket(id: Long): BucketsEntity

    @Update
    suspend fun updateBucket(bucket: BucketsEntity)

    @Query("DELETE FROM buckets WHERE id=:id")
    suspend fun deleteBucket(id: Long)
}