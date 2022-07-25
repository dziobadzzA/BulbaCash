package com.service.bulbacash.presentation.ui.stencil.item

import androidx.lifecycle.ViewModel
import com.service.bulbacash.di.AdapterCountries
import com.service.bulbacash.domain.models.Currency
import com.service.bulbacash.domain.models.ItemStencil
import com.service.bulbacash.domain.usecases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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

    private val _listItemStencil = MutableSharedFlow<MutableList<ItemStencil>>(replay = 1)
    val listItemStencil: SharedFlow<MutableList<ItemStencil>> = _listItemStencil.asSharedFlow()
    private val listWithItemStencil = mutableListOf<ItemStencil>()

    fun getListForSpinner() {
        CoroutineScope(Dispatchers.IO).launch {
            _list.value = getAllBucketsUseCase.invoke()
            mapAdapterCountries.setListAdapter(list.value)
        }
    }

    fun addItemToListStencil(name:String) {
        val tempItem = mapAdapterCountries.getCurrentElement()
        val item = ItemStencil(Cur_ID = tempItem.Cur_ID, costName = name)
        if (findItemList(item) == null) {
            listWithItemStencil.add(item)
        }
        else {
            editInListItemStencil(item)
        }
        coroutineUpdateList()
    }

    fun deleteInListItemStencil(itemStencil: ItemStencil) {
        listWithItemStencil.remove(itemStencil)
        coroutineUpdateList()
    }

    private fun coroutineUpdateList() {
        CoroutineScope(Dispatchers.IO).launch {
            _listItemStencil.emit(listWithItemStencil)
        }
    }

    private fun findItemList(item: ItemStencil): ItemStencil? =
        listWithItemStencil.find { itemStencil -> itemStencil == item }


    private fun editInListItemStencil(item: ItemStencil) {
        val index = listWithItemStencil.indexOf(item)
        listWithItemStencil[index].costName = item.costName
        listWithItemStencil[index].Cur_ID = item.Cur_ID
        coroutineUpdateList()
    }

}