package com.service.bulbacash.presentation.ui.buckets

import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.service.bulbacash.di.AdapterWorkBuckets
import com.service.bulbacash.di.MapperCountries
import com.service.bulbacash.domain.models.Currency
import com.service.bulbacash.domain.usecases.GetAllBucketsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WorkBucketsViewModel @Inject constructor(
    private val getAllBucketsUseCase: GetAllBucketsUseCase,
    private val mapMapperCountries: MapperCountries,
    private val mapAdapterWorkBuckets: AdapterWorkBuckets
):ViewModel() {

    private var _list = MutableStateFlow(listOf<Currency>())
    val list = _list.asStateFlow()

    fun getCurrency() {
        CoroutineScope(Dispatchers.IO).launch {
            _list.value = getAllBucketsUseCase.invoke()
        }
    }

    fun getListTextCountries() = mapMapperCountries.mapperCurrencyList(list.value)

    fun getImageIcon(item: Currency) = mapMapperCountries.getIconCountries(item.Cur_ID)

    fun getListenerToSpinner(imageView: ImageView) = mapAdapterWorkBuckets.getAdapterWorkBuckets(
        imageView = imageView, viewModel = this
    )

}