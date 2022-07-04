package com.service.bulbacash.data.db.dao

import androidx.room.*
import com.service.bulbacash.data.db.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BulbaCashDAO {

    // commands for models Rate
    @Insert
    suspend fun insertRate(rate: RateEntity)

    @Query("SELECT * FROM rate WHERE id = :id")
    fun getRate(id: Long): Flow<RateEntity>

    @Query("SELECT * FROM rate WHERE Cur_ID =:id ORDER BY id DESC LIMIT 1")
    suspend fun getRateForBucket(id: Long): RateEntity?

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

    @Query("SELECT * FROM currency WHERE Cur_ID=:id")
    suspend fun getCurrency(id:Long): CurrencyEntity

    @Update
    suspend fun updateCurrency(currency: CurrencyEntity)

    @Query("DELETE FROM currency WHERE Cur_ID=:id")
    suspend fun deleteCurrency(id: Long)

    @Query("DELETE FROM currency")
    suspend fun deleteAllCurrency()

    @Query("SELECT COUNT(id) FROM currency")
    suspend fun sizeTableCurrency():Int

    // commands for model ItemStencil
    @Insert
    suspend fun insertItemStencil(itemStencil: ItemStencilEntity)

    @Update
    suspend fun updateItemStencil(itemStencil: ItemStencilEntity)

    @Delete
    suspend fun deleteItemStencil(itemStencil: ItemStencilEntity)

    // commands for model LinkStencil
    @Insert
    suspend fun insertLinkStencil(linkStencil: LinkStencilEntity)

    @Query("SELECT * FROM item_stencil INNER JOIN link_stencil ON " +
            "item_stencil.id=link_stencil.item_id WHERE link_stencil.stencil_id=:stencil_id")
    suspend fun getListItemsStencil(stencil_id: Long):List<ItemStencilEntity>

    @Delete
    suspend fun deleteLinkStencil(linkStencil: LinkStencilEntity)

    // commands for model Stencil
    @Insert
    suspend fun insertStencil(Stencil: StencilEntity)

    @Update
    suspend fun updateStencil(Stencil: StencilEntity)

    @Delete
    suspend fun deleteStencil(Stencil: StencilEntity)
}