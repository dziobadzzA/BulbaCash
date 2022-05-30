package com.service.bulbacash.data.repositories

import com.service.bulbacash.data.api.BankApiService
import com.service.bulbacash.data.mappers.CurrencyPojoToCurrency
import com.service.bulbacash.domain.models.Currency
import com.service.bulbacash.domain.repositories.GetBucketsRepository
import javax.inject.Inject

class GetAllBucketsImpl@Inject constructor(
    private val bankApi: BankApiService,
    private val mapCurrencyPojoToCurrency: CurrencyPojoToCurrency):GetBucketsRepository {

    override suspend fun getCurrency(): List<Currency> {
        TODO("Not yet implemented")
    }

}