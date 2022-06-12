package com.service.bulbacash.data.repositories

import com.service.bulbacash.data.api.BankApiService
import com.service.bulbacash.data.db.dao.BulbaCashDAO
import com.service.bulbacash.data.mappers.CurrencyEntityToCurrency
import com.service.bulbacash.data.mappers.CurrencyPojoToCurrency
import com.service.bulbacash.data.mappers.CurrencyToCurrencyEntity
import com.service.bulbacash.domain.models.Currency
import com.service.bulbacash.domain.repositories.GetBucketsRepository
import javax.inject.Inject
import kotlin.Exception

class GetAllBucketsImpl@Inject constructor(
    private val bankApi: BankApiService,
    private val bulbaCashDAO: BulbaCashDAO,
    private val mapCurrencyToCurrencyEntity: CurrencyToCurrencyEntity,
    private val mapCurrencyEntityToCurrency: CurrencyEntityToCurrency,
    private val mapCurrencyPojoToCurrency: CurrencyPojoToCurrency):GetBucketsRepository {

    override suspend fun getCurrency(): List<Currency> {
        return try {
            val size = bulbaCashDAO.sizeTableCurrency()

            if (size > 0) {
                mapCurrencyEntityToCurrency.mapList(bulbaCashDAO.getAllCurrency()).sortedBy {
                    it.Cur_Name
                }
            }
            else {
                val list = mapCurrencyPojoToCurrency.mapList(bankApi.getCurrency())
                val resultList = mutableListOf<Currency>()
                for (item in list) {
                    if (item.Is_Cur_DateEnd) {
                        bulbaCashDAO.insertCurrency(mapCurrencyToCurrencyEntity.map(item))
                        resultList.add(item)
                    }
                }
                resultList.sortBy { it.Cur_Name }
                resultList.toList()
            }

        } catch (e: Exception){
            listOf()
        }
    }

    override suspend fun getUpdateCurrency(): List<Currency> {

        return try {
            bulbaCashDAO.deleteAllCurrency()
            getCurrency()
        }
        catch (e:Exception){
            listOf()
        }

    }

}