package com.service.bulbacash.domain.repositories

import com.service.bulbacash.domain.models.Currency

interface GetBucketsRepository {
    suspend fun getCurrency():List<Currency>
}