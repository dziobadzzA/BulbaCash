package com.service.bulbacash.presentation.ui.buckets

import androidx.lifecycle.ViewModel
import com.service.bulbacash.domain.models.Currency
import com.service.bulbacash.domain.usecases.GetAllBucketsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkBucketsViewModel @Inject constructor(
    private val getAllBucketsUseCase: GetAllBucketsUseCase,
):ViewModel() {

    var list: List<Currency> = listOf()

    fun getCurrency() {
        CoroutineScope(Dispatchers.IO).launch {
            list = getAllBucketsUseCase.invoke()
        }
    }
}