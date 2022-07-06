package com.service.bulbacash.presentation.ui.stencil.item

import androidx.lifecycle.ViewModel
import com.service.bulbacash.di.AdapterCountries
import com.service.bulbacash.domain.models.Currency
import com.service.bulbacash.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ItemStencilViewModel @Inject constructor(
   /* private val saveStencilUseCase: SaveStencilUseCase,
    private val deleteStencilUseCase: DeleteStencilUseCase,*/
    private val getAllBucketsUseCase: GetAllBucketsUseCase,
    val mapAdapterCountries: AdapterCountries

): ViewModel() {

    private var _list = MutableStateFlow(listOf<Currency>())
    val list = _list.asStateFlow()

    fun getListForSpinner() {
        CoroutineScope(Dispatchers.IO).launch {
            _list.value = getAllBucketsUseCase.invoke()
            mapAdapterCountries.setListAdapter(list.value)
        }
    }

}