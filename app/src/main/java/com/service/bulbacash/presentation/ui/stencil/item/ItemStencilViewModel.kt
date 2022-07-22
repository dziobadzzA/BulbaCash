package com.service.bulbacash.presentation.ui.stencil.item

import androidx.lifecycle.ViewModel
import com.service.bulbacash.di.AdapterCountries
import com.service.bulbacash.domain.models.Currency
import com.service.bulbacash.domain.models.ItemStencil
import com.service.bulbacash.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
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

    //private var _listItemStencil = MutableStateFlow(mutableListOf<ItemStencil>())
    //val listItemStencil = _listItemStencil.asStateFlow()

    private val _listItemStencil = MutableSharedFlow<MutableList<ItemStencil>>(replay = 0)
    val listItemStencil: SharedFlow<MutableList<ItemStencil>> = _listItemStencil
    private val listWithItemStencil = mutableListOf<ItemStencil>()

    fun getListForSpinner() {
        CoroutineScope(Dispatchers.IO).launch {
            _list.value = getAllBucketsUseCase.invoke()
            mapAdapterCountries.setListAdapter(list.value)
        }
    }

    fun addItemToListStencil(name:String) {
        val test = mapAdapterCountries.getCurrentElement()
        val item = ItemStencil(Cur_ID = test.Cur_ID, costName = name)
        listWithItemStencil.add(item)
        CoroutineScope(Dispatchers.IO).launch {
            _listItemStencil.emit(listWithItemStencil)
        }
    }

    fun deleteInListItemStencil(index: Int) {
        listWithItemStencil.removeAt(index)
    }

}