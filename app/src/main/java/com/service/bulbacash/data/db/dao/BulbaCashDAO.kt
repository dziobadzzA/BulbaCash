package com.service.bulbacash.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.service.bulbacash.data.db.entity.BucketsEntity
import com.service.bulbacash.data.db.entity.CurrencyEntity
import com.service.bulbacash.data.db.entity.RateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BulbaCashDAO {

    // commands for models Rate
    @Insert
    suspend fun insertRate(token: RateEntity)

    @Query("SELECT * FROM rate WHERE id = :id")
    fun getRate(id: Long): Flow<RateEntity>

    @Update
    suspend fun updateRate(rate: RateEntity)

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

    @Query("SELECT * FROM buckets")
    suspend fun getAllBuckets(): List<BucketsEntity>

    // commands for models Currency
    @Insert
    suspend fun insertCurrency(currency: CurrencyEntity)

    @Query("SELECT * FROM currency")
    suspend fun getAllCurrency(): List<CurrencyEntity>

    @Query("SELECT * FROM currency WHERE id=:id")
    suspend fun getCurrency(id:Long): CurrencyEntity

    @Update
    suspend fun updateCurrency(currency: CurrencyEntity)

    @Query("DELETE FROM currency WHERE id=:id")
    suspend fun deleteCurrency(id: Long)

    @Query("DELETE FROM currency")
    suspend fun deleteAllCurrency()

    @Query("SELECT COUNT(id) FROM currency")
    suspend fun sizeTableCurrency():Int
}