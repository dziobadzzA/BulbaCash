package com.service.bulbacash.presentation.ui.buckets

import android.content.Context
import androidx.lifecycle.ViewModel
import com.service.bulbacash.data.mappers.CurrencyEntityToCurrency
import com.service.bulbacash.domain.models.Currency
import com.service.bulbacash.domain.usecases.GetAllBucketsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkBucketsViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val getAllBucketsUseCase: GetAllBucketsUseCase,
    private val mapCurrencyEntityToCurrency: CurrencyEntityToCurrency
):ViewModel() {

    var list: List<Currency> = listOf()

    fun getCurrency() {
        CoroutineScope(Dispatchers.IO).launch {
            list = getAllBucketsUseCase.invoke()
        }
    }
}