package com.service.bulbacash.data.mappers

import com.service.bulbacash.data.api.BankApiService
import com.service.bulbacash.data.db.dao.BulbaCashDAO
import com.service.bulbacash.data.db.entity.BucketsEntity
import com.service.bulbacash.data.db.entity.RateEntity
import com.service.bulbacash.domain.models.BucketRate
import com.service.bulbacash.domain.models.Rate
import com.service.bulbacash.domain.utill.Mapper

class BucketsEntityToBucketRate(
    private val bulbaCashDAO: BulbaCashDAO,
    private val mapperRateEntityToRate: RateEntityToRate,
    private val mapperRateToRateEntity: RateToRateEntity,
    private val bankApi: BankApiService,
    private val mapperRatePojoToRate: RatePojoToRate) {

     private suspend fun correctMapAPI(rateEntity: RateEntity?, id: Int): Rate? {

         if (rateEntity == null) {

             val rate = bankApi.getRateToday(id=id)?.let {
                 mapperRatePojoToRate.map(
                     it
                 )
             }

             return if (rate == null)
                 null
             else {
                 bulbaCashDAO.insertRate(mapperRateToRateEntity.map(rate))
                 rate
             }

         }

         return null
     }

     suspend fun map(from: BucketsEntity): BucketRate {

        val firstDBElement = bulbaCashDAO.getRateForBucket(id=from.firstRate)
        val secondDBElement = bulbaCashDAO.getRateForBucket(id=from.secondRate)

         val firstElement = if (correctMapAPI(firstDBElement, from.firstRate.toInt()) != null) {
             correctMapAPI(firstDBElement, from.firstRate.toInt())
         } else {
             firstDBElement?.let { mapperRateEntityToRate.map(it) }
         }

         val secondElement = if (correctMapAPI(secondDBElement, from.secondRate.toInt()) != null) {
             correctMapAPI(secondDBElement, from.secondRate.toInt())
         } else {
             secondDBElement?.let { mapperRateEntityToRate.map(it) }
         }

         return BucketRate(
            firstElement = firstElement,
            secondElement = secondElement,
            coeffiecient = secondElement?.let { firstElement?.Cur_OfficialRate?.div(it.Cur_OfficialRate) }
                ?: 0.0,
            typeFirst = 1,
            typeSecond = 1,
            ID = from.id
         )
    }

    suspend fun mapList(list: List<BucketsEntity>): List<BucketRate> {

        val resultList = mutableListOf<BucketRate>()

        for (item in list) {
            val test = map(item)
            resultList.add(test)
        }


        return resultList
    }

}

class BucketsRateToBucketEntity: Mapper<BucketRate, BucketsEntity> {

    override fun map(from: BucketRate): BucketsEntity {
        return BucketsEntity(
            id = from.ID,
            firstRate = (from.firstElement?.Cur_ID ?: 0L) as Long,
            secondRate = (from.secondElement?.Cur_ID ?: 0L) as Long
        )
    }
}