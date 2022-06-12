package com.service.bulbacash.data.mappers

import com.service.bulbacash.data.db.dao.BulbaCashDAO
import com.service.bulbacash.data.db.entity.BucketsEntity
import com.service.bulbacash.domain.models.BucketRate
import com.service.bulbacash.domain.utill.Mapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first

class BucketsEntityToBucketRate(
        private val bulbaCashDAO: BulbaCashDAO,
        private val mapperRateEntityToRate: RateEntityToRate) {

    suspend fun map(from: BucketsEntity): BucketRate {

        val bucketRate = CoroutineScope(Dispatchers.IO).async {
            val firstFlowElement = bulbaCashDAO.getRate(id = from.firstRate)
            val secondFlowElement = bulbaCashDAO.getRate(id = from.secondRate)

            val firstElement = mapperRateEntityToRate.map(firstFlowElement.first())
            val secondElement = mapperRateEntityToRate.map(secondFlowElement.first())

            val bucket = BucketRate(
                firstElement = firstElement,
                secondElement = secondElement,
                coeffiecient = firstElement.Cur_OfficialRate / secondElement.Cur_OfficialRate,
                typeFirst = 1,
                typeSecond = 1,
                ID = from.id
            )
            bucket
        }

        return bucketRate.await()
    }

    suspend fun mapList(list: List<BucketsEntity>): List<BucketRate> {

        val resultList = mutableListOf<BucketRate>()

        for (item in list)
            resultList.add(map(item))

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